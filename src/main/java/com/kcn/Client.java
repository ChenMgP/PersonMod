package com.kcn;

import com.kcn.commands.ChestFoundCommand;
import com.kcn.commands.IdCardCommand;
import com.kcn.commands.NbtCommand;
import com.kcn.commands.UUIDCommand;
import com.kcn.networking.ModPacket;
import com.kcn.util.ClientData;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class Client implements ClientModInitializer {

    private static KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding("d", InputUtil.Type.KEYSYM, InputUtil.GLFW_KEY_H, "f"));

    public Client() {
    }

    @Override
    public void onInitializeClient() {
        ModPacket.registerS2CPacket();
        ClientLifecycleEvents.CLIENT_STARTED.register(
                client -> {
                    ClientData.ModScreenRegistry.init();
                    ClientData.BlockRenderRegistry.init();
                    ClientData.ClientFile.init();
                }
        );
        CommandRegistrationCallback.EVENT.register(
                (dispatcher, dedicated) -> {
                    NbtCommand.register(dispatcher);
                    IdCardCommand.register(dispatcher);
                    ChestFoundCommand.register(dispatcher);
                    UUIDCommand.register(dispatcher);
                }
        );
        ClientTickEvents.END_CLIENT_TICK.register(
                client -> {
                    while (keyBinding.wasPressed()) {
                        ClientPlayNetworking.send(ModPacket.WATER_SERVER_ID, PacketByteBufs.create());
                    }
                }
        );
    }
}
