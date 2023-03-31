package com.kcn.mixin;

import com.kcn.util.IAuthenticationData;
import com.kcn.util.IChestData;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayerEntity.class)
public class ServerPlayerMixin {

    ServerPlayerEntity player = ((ServerPlayerEntity) (Object) this);

    @Inject(at = @At("HEAD"), method = "copyFrom")
    public void copyFrom(ServerPlayerEntity oldPlayer, boolean alive, CallbackInfo ci) {
        ((IAuthenticationData) player).setAuthentication(((IAuthenticationData) oldPlayer).getAuthentication());
        ((IChestData) player).setChestData(((IChestData) oldPlayer).getChestData());
    }

}
