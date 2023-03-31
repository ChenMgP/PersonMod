package com.kcn.screen.handler;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandler {
    public static final ScreenHandlerType<WaterPurifierScreenHandler> WATER_PURIFIER_SCREEN_HANDLER;
    public static final ScreenHandlerType<HealthHandler> HEALTH_SCREEN_HANDLER;
    public static final ScreenHandlerType<BagScreenHandler> BAG_SCREEN_HANDLER;

    static {
        HEALTH_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("kcn", "test"), (syncId, inventory) -> new HealthHandler(syncId));
        WATER_PURIFIER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("kcn", "water_purifier"), WaterPurifierScreenHandler::new);
        BAG_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("kcn", "bag"), BagScreenHandler::new);
    }

    public static void screenHandler() {}
}
