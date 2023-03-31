package com.kcn.util;

import net.minecraft.nbt.NbtCompound;

public interface IChestData {

    NbtCompound getChestData();

    void setChestData(NbtCompound compound);

}
