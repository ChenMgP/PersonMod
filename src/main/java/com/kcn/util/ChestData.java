package com.kcn.util;

import net.minecraft.nbt.NbtCompound;

public class ChestData {

    public static void writePlayerNbt(IChestData player, int x, int y, int z) {
        NbtCompound chestData = player.getChestData();
        chestData.putInt("x", x);
        chestData.putInt("y", y);
        chestData.putInt("z", z);
    }

    public static boolean isSpawnChest(IChestData player) {
        return player.getChestData().getBoolean("is_spawn");
    }

    public static void setSpawnChest(IChestData player, boolean flag) {
        player.getChestData().putBoolean("is_spawn", flag);
    }

}
