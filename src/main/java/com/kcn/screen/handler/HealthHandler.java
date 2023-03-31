package com.kcn.screen.handler;

import com.kcn.util.Data;
import com.kcn.util.DataGetterInf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;

public class HealthHandler extends ScreenHandler {

    private String water;
    private boolean has_parasite;
    private String parasite;

    public HealthHandler(int syncId) {
        super(ModScreenHandler.HEALTH_SCREEN_HANDLER, syncId);
    }

    public HealthHandler(int syncId, ServerPlayerEntity player) {
        super(ModScreenHandler.HEALTH_SCREEN_HANDLER, syncId);
        Data data = ((DataGetterInf) player).getData();
        this.water = String.valueOf(data.getWater());
        this.has_parasite = data.hasParasite();
        this.parasite = String.valueOf(data.getParasite());
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }

    public String getWater() {
        return water;
    }

    public boolean hasParasite() {
        return has_parasite;
    }

    public String getParasite() {
        return parasite;
    }
}
