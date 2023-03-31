package com.kcn.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.LiteralText;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class NbtCommand {

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(literal("nbt")
                .requires(commandSource -> commandSource.hasPermissionLevel(4))
                .then(argument("slot", IntegerArgumentType.integer())
                        .requires(commandSource -> commandSource.hasPermissionLevel(4))
                        .executes(context -> broadcast(IntegerArgumentType.getInteger(context, "slot"), context.getSource().getPlayer()))));
    }

    public static int broadcast(int value, PlayerEntity player) {
        if (value >= 0 && value <= 40) {
            ItemStack stack = player.getInventory().getStack(value);
            if (stack.hasNbt()) {
                assert stack.getNbt() != null;
                String s = stack.getNbt().toString();
                player.sendMessage(new LiteralText(s), false);
                return Command.SINGLE_SUCCESS;
            } else {
                player.sendMessage(new LiteralText("This item has no NBT"), false);
            }
            return 0;
        } else if (value < 0) {
            player.sendMessage(new LiteralText("The value you entered is too small"), false);
        } else {
            player.sendMessage(new LiteralText("The value you entered is too large"), false);
        }
        return 0;
    }
}
