package com.kcn.mixin;

import com.kcn.util.IAuthenticationData;
import com.kcn.util.IChestData;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class EntityMixin implements IAuthenticationData, IChestData {

    private NbtCompound authentication;
    private NbtCompound chest;

    @Inject(at = @At("HEAD"), method = "readNbt")
    public void readNbt(NbtCompound nbt, CallbackInfo ci) {
        if (nbt.contains("Authentication", 10)) {
            authentication = nbt.getCompound("Authentication");
        }
        if (nbt.contains("Chest", 10)) {
            chest = nbt.getCompound("Chest");
        }
    }

    @Inject(at = @At("HEAD"), method = "writeNbt")
    public void writeNbt(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        if (authentication != null) {
            nbt.put("Authentication", authentication);
        }
        if (chest != null) {
            nbt.put("Chest", chest);
        }
    }

    @Override
    public NbtCompound getAuthentication() {
        if (authentication == null) {
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putBoolean("is_authentication", false);
            nbtCompound.putBoolean("is_tip", false);
            nbtCompound.putBoolean("is_child", false);
            nbtCompound.putBoolean("is_teleport", false);
            authentication = nbtCompound;
            return authentication;
        }
        return authentication;
    }

    @Override
    public void setAuthentication(NbtCompound compound) {
        authentication = compound;
    }

    @Override
    public NbtCompound getChestData() {
        if (chest == null) {
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putInt("x", 0);
            nbtCompound.putInt("y", 0);
            nbtCompound.putDouble("z", 0);
            nbtCompound.putBoolean("is_spawn", false);
            chest = nbtCompound;
            return chest;
        }
        return chest;
    }

    @Override
    public void setChestData(NbtCompound compound) {
        chest = compound;
    }
}
