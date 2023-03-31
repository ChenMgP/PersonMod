package com.kcn;

import com.kcn.blocks.ModBlock;
import com.kcn.blocks.entities.ModBlockEntity;
import com.kcn.effects.ModEffect;
import com.kcn.items.ModItem;
import com.kcn.networking.ModPacket;
import com.kcn.recipes.ModRecipe;
import com.kcn.screen.handler.ModScreenHandler;
import com.kcn.util.PlayerTickHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class Main implements ModInitializer {

    public Main() {
    }

    public static void main(String[] args) {

    }

    @Override
    public void onInitialize() {
        ModItem.item();
        ModBlock.block();
        ModBlockEntity.init();
        ModScreenHandler.screenHandler();
        ModRecipe.recipe();
        ModPotion.potion();
        ModEffect.effect();
        ModPacket.registerC2SPacket();
        ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());
    }
}
