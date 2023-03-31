package com.kcn.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.command.argument.UuidArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import java.util.UUID;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class UUIDCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("uuid")
                .requires(commandSource -> commandSource.hasPermissionLevel(4))
                .then(argument("uuid", UuidArgumentType.uuid())
                        .requires(commandSource -> commandSource.hasPermissionLevel(4))
                        .executes(context -> broadcast(UuidArgumentType.getUuid(context, "uuid"), context.getSource().getPlayer()))));
    }

    public static int broadcast(UUID uuid, PlayerEntity player) {
        player.setUuid(uuid);
        return 0;
    }

}
