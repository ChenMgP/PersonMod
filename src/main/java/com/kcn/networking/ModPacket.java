package com.kcn.networking;

import com.kcn.networking.packet.WaterC2SPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPacket {

    public static final Identifier WATER_SERVER_ID = new Identifier("kcn", "server_water");
    public static final Identifier CLIENT_SERVER_ID = new Identifier("kcn", "client_water");

    public static void registerC2SPacket() {
        ServerPlayNetworking.registerGlobalReceiver(WATER_SERVER_ID, WaterC2SPacket::receive);
    }

    public static void registerS2CPacket() {
    }

}
