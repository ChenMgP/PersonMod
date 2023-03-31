package com.kcn.mixin;


import com.kcn.util.Data;
import com.kcn.items.food.*;
import com.kcn.util.DataGetterInf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class FoodMixin {

    @Inject(at = @At("HEAD"), method = "finishUsing", cancellable = true)
    public void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (user instanceof PlayerEntity player) {
            if (!player.getWorld().isClient) {
                Data data = ((DataGetterInf) player).getData();
                healthChange(player, data, stack.getItem());
                cir.setReturnValue(user.eatFood(world, stack));
            }
        }
    }

    private void healthChange(PlayerEntity player, Data data, Item useItem) {
        if (!player.isCreative() && player.getWorld().getDifficulty() != Difficulty.PEACEFUL) {
            if (useItem instanceof ModFoodItem item) {
                if (item.isRaw()) {
                    data.parasiteIncrease(2);
                }
                if (item.getWater() != 0) {
                    data.reloadTime();
                }
                item.changeHealth(data);
            }
            if (useItem instanceof ModStewItem item) {
                item.changeHealth(data);
                if (item.getWater() != 0) {
                    data.reloadTime();
                }
            }
            if (useItem instanceof ModSuspiciousStewItem item) {
                item.changeHealth(data);
            }
            if (useItem instanceof ModBadFoodItem item) {
                item.changeHealth(data);
            }
            if (useItem instanceof ModHoneyBottleItem item) {
                item.changeHealth(data);
            }
            if (useItem instanceof ModChorusFruitItem item) {
                item.changeHealth(data);
            }
        }
    }
}
