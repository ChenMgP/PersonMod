package com.kcn.commands;

import com.kcn.blocks.ModBlock;
import com.kcn.blocks.entities.chest.AChestEntity;
import com.kcn.util.ChestData;
import com.kcn.util.IChestData;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import static net.minecraft.server.command.CommandManager.literal;

public class ChestFoundCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("chest")
                .then(literal("spawnChest").executes(context -> spawn(context.getSource().getPlayer())))
                .then(literal("getPlace").executes(context -> found(context.getSource().getPlayer()))));
    }

    private static int spawn(PlayerEntity player) {
        if (!player.getWorld().isClient()) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
            if (!ChestData.isSpawnChest(((IChestData) player))) {
                int x = (int) Math.abs(serverPlayer.getX());
                if (x == 0) {
                    x = x + 1;
                }
                int y = (int) Math.abs(serverPlayer.getY());
                if (y == 0) {
                    y = y + 1;
                }
                int z = (int) Math.abs(serverPlayer.getZ());
                if (z == 0) {
                    z = z + 1;
                }
                Random random = new Random();
                int i = random.nextInt(x * -75, x * 75);
                int j = random.nextInt(-60, y);
                int k = random.nextInt(z * -75, z * 75);
                while (true) {
                    World world = player.getWorld();
                    if (world.getBlockState(new BlockPos(i, j, k)).getBlock() == Blocks.AIR) {
                        i = random.nextInt(x * -75, x * 75);
                        j = random.nextInt(-60, y);
                        k = random.nextInt(z * -75, z * 75);
                    } else {
                        world.setBlockState(new BlockPos(i, j, k), ModBlock.A_CHEST.getDefaultState());
                        AChestEntity blockEntity = (AChestEntity) world.getBlockEntity(new BlockPos(i, j, k));
                        assert blockEntity != null;
                        blockEntity.setOwner(player.getUuidAsString());
                        ChestData.writePlayerNbt(((IChestData) serverPlayer), i, j, k);
                        serverPlayer.sendMessage(new LiteralText("最新的宝箱位置已确定").formatted(Formatting.RED), false);
                        ChestData.setSpawnChest(((IChestData) serverPlayer), true);
                        return 0;
                    }
                }
            } else {
                serverPlayer.sendMessage(new LiteralText("请先把已发现的宝箱开启，再寻找新的宝箱").formatted(Formatting.RED), false);
            }
        }
        return 0;
    }

    private static int found(PlayerEntity player) {
        if (!player.getWorld().isClient()) {
            ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
            if (ChestData.isSpawnChest((IChestData) serverPlayer)) {
                NbtCompound chestData = ((IChestData) serverPlayer).getChestData();
                int x = chestData.getInt("x");
                int y = chestData.getInt("y");
                int z = chestData.getInt("z");
                serverPlayer.sendMessage(new LiteralText("宝箱在").formatted(Formatting.GREEN).append(new LiteralText("[" + x + ", " + y + ", " + z + "]").formatted(Formatting.YELLOW)), false);
                return 0;
            } else {
                serverPlayer.sendMessage(new LiteralText("未定位到宝箱").formatted(Formatting.RED), false);
            }
        }
        return 0;
    }
}


