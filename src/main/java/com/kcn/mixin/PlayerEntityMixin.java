package com.kcn.mixin;

import com.kcn.util.Data;
import com.kcn.util.IDataGetter;
import com.kcn.util.DataGetterInf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin implements DataGetterInf, IDataGetter {

    private final PlayerEntity PLAYER = (PlayerEntity) (Object) this;
    private final Data DATA = new Data();

    @Inject(at = @At("TAIL"), method = "readCustomDataFromNbt")
    public void readCustomDataFromNbt(NbtCompound nbt, CallbackInfo ci) {
        DATA.readNbt(nbt);
    }

    @Inject(at = @At("TAIL"), method = "writeCustomDataToNbt")
    public void writeCustomDataToNbt(NbtCompound nbt, CallbackInfo ci) {
        DATA.writeNbt(nbt);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo ci) {
        DATA.update(PLAYER);
    }

    @Override
    public Data getData() {
        return DATA;
    }



}
