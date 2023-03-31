package com.kcn.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.network.ServerPlayerEntity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;

public final class JsonFileHelper {

    private JsonFileHelper() {}

    private static void method_4574() throws Exception {
        Path gameDir = FabricLoader.getInstance().getGameDir();
        File file = new File(gameDir + "\\h5f2us4y389hf832.json");
        if (!file.isFile()) {
            file.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("{}");
            bw.close();
        }
    }

    private static void readValue() {
        Path gameDir = FabricLoader.getInstance().getGameDir();
        File file = new File(gameDir + "\\h5f2us4y389hf832.json");
    }

    private static void writeValue(ServerPlayerEntity player) throws Exception {
        Path gameDir = FabricLoader.getInstance().getGameDir();
        String path = new File(gameDir + "\\h5f2us4y389hf832.json").getPath();
        JsonParser parser = new JsonParser();
        JsonElement parse = parser.parse(path);
    }

    public static void createNewFile() {
        try {
            method_4574();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
