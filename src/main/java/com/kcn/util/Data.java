package com.kcn.util;

import com.kcn.Damages;
import com.kcn.effects.ModEffect;
import com.kcn.util.JsonHelper;
import com.kcn.util.ModMath;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Data {

    private int parasite = 0;
    private boolean has_parasite = false;
    private int water = 20;
    private int tick = 0;
    private int badTick = 0;
    private int coldTick = 0;
    private int fat = 100;
    private int protein = 100;
    private int carbohydrate = 100;

    public Data() {}

    public void parasiteIncrease(int amount) {
        has_parasite = true;
        parasite += amount;
    }

    public void parasiteDecrease(int amount) {
        int a = parasite - amount;
        if (a == 0) {
            has_parasite = false;
        }
        parasite = Math.max(a, 0);
    }

    public void increase(int amount) {
        water = Math.min(water + amount, 20);
    }

    public void decrease(int amount) {
        water = Math.max(water - amount, 0);
    }

    public void increaseFat(int amount) {
        fat = Math.min(fat + amount, 100);
    }

    public void decreaseFat(int amount) {
        fat = Math.max(fat - amount, 0);
    }

    public void increaseProtein(int amount) {
        protein = Math.min(protein + amount, 100);
    }

    public void decreaseProtein(int amount) {
        protein = Math.max(protein - amount, 0);
    }

    public void increaseCarbohydrate(int amount) {
        carbohydrate = Math.min(carbohydrate + amount, 100);
    }

    public void decreaseCarbohydrate(int amount) {
        carbohydrate = Math.max(carbohydrate - amount, 0);
    }

    public void reloadTime() {
        tick = 0;
        badTick = 0;
    }

    public void update(@NotNull PlayerEntity player) {
        Difficulty difficulty = player.getWorld().getDifficulty();
        boolean creative = player.isCreative();
        if (!creative && difficulty != Difficulty.PEACEFUL && !player.getWorld().isClient()) {
            tick++;
            /*
               In this mod,
               The zone with temperature greater than or equal to 0.6 is called tropical zone,
               The area with temperature less than or equal to 0.05 is called cold zone area.
              */
            if (has_parasite) {
                int temp = parasite;
                Random random = new Random();
                double v = random.nextDouble();
                if (v <= ModMath.NUMBER_OF_HEALTH_CHANGES) {
                    tickSpeed(temp * 2);
                }
            }
            if (carbohydrate <= 0 && protein <= 0 && fat <= 0) {
                player.damage(Damages.HEALTH, Float.MAX_VALUE);
            }
            if (player.getWorld().getBiome(player.getBlockPos()).getTemperature() >= 0.6f) {
                tickSpeed(4);
            }
            if (player.getWorld().getBiome(player.getBlockPos()).getTemperature() <= 0.05f && fat <= 20) {
                player.addStatusEffect(new StatusEffectInstance(ModEffect.COLD, 2, 0));
                coldTick++;
                if (coldTick >= 20 * 2.5) {
                    coldTick = 0;
                    coldDamage(player);
                }
            }
            if ((player.isOnFire() && !player.hasStatusEffect(ModEffect.ADVANCED_FIRE_PROTECTION)) || (player.isInLava() && !player.hasStatusEffect(ModEffect.ADVANCED_FIRE_PROTECTION))) {
                tickSpeed(10);
            }
            if (tick >= 20 * 120) {
                tick = 0;
                decrease(1);
                decreaseFat(3);
                decreaseCarbohydrate(5);
                decreaseProtein(3);
            }
            if (water <= 0 || (carbohydrate <= 0 && fat <= 0 && protein <= 0)) {
                badTick++;
                if (badTick >= 20 * 2.5) {
                    badTick = 0;
                    damage(player);
                }
            }
            if (carbohydrate <= 0) {
                decreaseFat(5);
            }
            if (carbohydrate <= 0 && fat <= 0) {
                decreaseProtein(5);
            }
        }
    }

    public void readNbt(@NotNull NbtCompound nbt) {
        NbtCompound healthData = nbt.getCompound("healthData");
        parasite = healthData.getInt("parasite");
        has_parasite = healthData.getBoolean("has_parasite");
        water = healthData.getInt("water");
        tick = healthData.getInt("tick");
        badTick = healthData.getInt("badTick");
        fat = healthData.getInt("fat");
        protein = healthData.getInt("protein");
        carbohydrate = healthData.getInt("carbohydrate");
        coldTick = healthData.getInt("coldTick");
    }

    public void writeNbt(@NotNull NbtCompound nbt) {
        NbtCompound nbtCompound = new NbtCompound();
        nbtCompound.putInt("parasite", parasite);
        nbtCompound.putBoolean("has_parasite", has_parasite);
        nbtCompound.putInt("water", water);
        nbtCompound.putInt("tick", tick);
        nbtCompound.putInt("badTick", badTick);
        nbtCompound.putInt("fat", fat);
        nbtCompound.putInt("protein", protein);
        nbtCompound.putInt("carbohydrate", carbohydrate);
        nbtCompound.putInt("coldTick", coldTick);
        nbt.put("healthData", nbtCompound);
    }


    public int getWater() {
        return water;
    }

    public boolean hasParasite() {
        return has_parasite;
    }

    public int getParasite() {
        return parasite;
    }

    public void tickSpeed(int i) {
        tick = tick + i;
    }

    public void sendHealthReport(ServerPlayerEntity player) {
        sendMessage(player, player.getEntityName() + "的健康状况: ", null);
        sendMessage(player, "水分: " + water + "/20", Formatting.AQUA);
        sendMessage(player, "蛋白质: " + protein + "/100", Formatting.LIGHT_PURPLE);
        sendMessage(player, "碳水化合物: " + carbohydrate + "/100", Formatting.YELLOW);
        sendMessage(player, "脂肪: " + fat + "/100", Formatting.GREEN);
        if (has_parasite) {
            sendMessage(player, "寄生虫数: " + parasite + "/∞", Formatting.RED);
        }
    }

    private void sendMessage(ServerPlayerEntity player, String message, Formatting formatting) {
        if (formatting == null) {
            player.sendMessage(new LiteralText(message), false);
        } else {
            player.sendMessage(new LiteralText(message).formatted(formatting), false);
        }
    }

    private void damage(PlayerEntity player) {
        player.damage(Damages.HEALTH, 3f);
    }

    private void coldDamage(PlayerEntity player) {
        player.damage(Damages.COLD, 4f);
    }

    public void land(PlayerEntity entity) {
        World world = entity.getWorld();
        if (!world.isClient()) {
            ServerWorld serverWorld = (ServerWorld) world;
            BlockPos spawnPos = serverWorld.getSpawnPos();
            entity.requestTeleport(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
        }
    }
}
