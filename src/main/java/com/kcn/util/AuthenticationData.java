package com.kcn.util;

import net.minecraft.nbt.NbtCompound;

public class AuthenticationData {

    public static boolean isTeleport(IAuthenticationData player) {
        return player.getAuthentication().getBoolean("is_teleport");
    }

    public static void setTeleport(IAuthenticationData player) {
        NbtCompound authentication = player.getAuthentication();
        authentication.putBoolean("is_teleport", true);
    }

    public static boolean isTip(IAuthenticationData player) {
        return player.getAuthentication().getBoolean("is_tip");
    }

    public static void setTip(IAuthenticationData player) {
        NbtCompound authentication = player.getAuthentication();
        authentication.putBoolean("is_tip", true);
    }

    public static void setChild(IAuthenticationData player) {
        NbtCompound authentication = player.getAuthentication();
        authentication.putBoolean("is_authentication", true);
        authentication.putBoolean("is_child", true);
    }

    public static void setAuthentication(IAuthenticationData player) {
        NbtCompound authentication = player.getAuthentication();
        authentication.putBoolean("is_authentication", true);
    }

    public static boolean isAuthentication(IAuthenticationData player) {
        NbtCompound authentication = player.getAuthentication();
        return authentication.getBoolean("is_authentication");
    }

    public static boolean isChild(IAuthenticationData player) {
        NbtCompound authentication = player.getAuthentication();
        return authentication.getBoolean("is_child");
    }

}
