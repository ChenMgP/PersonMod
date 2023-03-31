package com.kcn.networking.packet;

import com.kcn.util.Data;
import com.kcn.util.DataGetterInf;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class WaterC2SPacket {

    public static void receive(MinecraftServer server, ServerPlayerEntity serverPlayer, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender sender) {
        Data data = ((DataGetterInf)serverPlayer).getData();
        data.sendHealthReport(serverPlayer);
    }
}
