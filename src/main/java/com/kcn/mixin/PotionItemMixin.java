package com.kcn.mixin;

import com.kcn.util.Data;
import com.kcn.util.DataGetterInf;
import com.kcn.util.ModMath;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;
import java.util.Random;

@Mixin(PotionItem.class)
public class PotionItemMixin {

    @Inject(at = @At("HEAD"), method = "finishUsing")
    public void finishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (user instanceof PlayerEntity player) {
            if (!player.world.isClient()) {
                Data data = ((DataGetterInf) player).getData();
                if (Objects.equals(stack.getNbt(), Items.POTION.getDefaultStack().getNbt())) {
                    data.reloadTime();
                    data.increase(2);
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * 7, 1));
                    Random random = new Random();
                    double d = random.nextDouble();
                    if (d < ModMath.PROBABILITY_EQUILIBRIUM_NUMBER) {
                        data.parasiteIncrease(2);
                    }
                } else {
                    data.reloadTime();
                    data.increase(2);
                }
            }
        }
    }
}
