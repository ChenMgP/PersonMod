package com.kcn.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    private static final Path path = FabricLoader.getInstance().getGameDir();

    public static ArrayList<Object> getNbt(PlayerEntity player) throws FileNotFoundException {
        JsonObject object = (JsonObject) JsonParser.parseReader(new FileReader(path + "\\3625729657.json"));
        JsonObject data = object.getAsJsonObject(player.getEntityName());
        long onlineTime = data.get("onlineTime").getAsLong();
        boolean isAttestation = data.get("is_attestation").getAsBoolean();
        boolean isChild = data.get("is_child").getAsBoolean();
        boolean isTeleport = data.get("is_teleport").getAsBoolean();
        boolean isTip = data.get("is_tip").getAsBoolean();
        int date = data.get("date").getAsInt();
        ArrayList<Object> arr = new ArrayList<>();
        arr.add(List.of(onlineTime, isAttestation, isChild, isTeleport, isTip, date));
        return arr;
    }

    public static void setNbt(PlayerEntity player, NbtCompound nbt) throws IOException {
        JsonObject object = (JsonObject) JsonParser.parseReader(new FileReader(path + "\\3625729657.json"));
        JsonObject obj = new JsonObject();
        NbtCompound authentication = nbt.getCompound("Authentication");
        int onLineTime = authentication.getInt("onLineTime");
        boolean isAttestation = authentication.getBoolean("isAttestation");
        boolean isChild = authentication.getBoolean("isChild");
        int date = authentication.getInt("date");
        boolean isTeleport = authentication.getBoolean("isTeleport");
        boolean isTip = authentication.getBoolean("isTip");
        obj.addProperty("onlineTime", onLineTime);
        obj.addProperty("is_attestation", isAttestation);
        obj.addProperty("is_child", isChild);
        obj.addProperty("date", date);
        obj.addProperty("isTeleport", isTeleport);
        obj.addProperty("isTip", isTip);
        object.add(player.getEntityName(), obj);
        String s = object.toString();
        BufferedWriter bw = new BufferedWriter(new FileWriter(path + "\\3625729657.json"));
        bw.write(s);
        bw.close();
    }


}
