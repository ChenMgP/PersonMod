package com.kcn.screen.handler;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler {
    public static final ScreenHandlerType<WaterPurifierScreenHandler> WATER_PURIFIER_SCREEN_HANDLER;
    public static final ScreenHandlerType<HealthHandler> HEALTH_SCREEN_HANDLER;
    public static final ScreenHandlerType<BagScreenHandler> BAG_SCREEN_HANDLER;
    public static final ScreenHandlerType<ChestScreenHandler> CHEST_SCREEN_HANDLER;
    public static final ScreenHandlerType<OpenChestHandler> OPEN_CHEST_HANDLER;

    static {
        OPEN_CHEST_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("kcn", "open_chest"), OpenChestHandler::new);
        CHEST_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("kcn", "chest"), ChestScreenHandler::new);
        HEALTH_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("kcn", "test"), (syncId, inventory) -> new HealthHandler(syncId));
        WATER_PURIFIER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("kcn", "water_purifier"), WaterPurifierScreenHandler::new);
        BAG_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("kcn", "bag"), BagScreenHandler::new);
    }

    public static void screenHandler() {}
}
