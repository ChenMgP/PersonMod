package com.kcn.util;

import net.minecraft.nbt.NbtCompound;

public interface IAuthenticationData {

    NbtCompound getAuthentication();

    void setAuthentication(NbtCompound compound);

}
