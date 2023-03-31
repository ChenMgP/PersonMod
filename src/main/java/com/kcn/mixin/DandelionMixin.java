package com.kcn.mixin;

import com.kcn.util.Data;
import com.kcn.util.DataGetterInf;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractBlock.class)
public abstract class DandelionMixin {
    @Inject(at = @At("HEAD"), method = "onUse", cancellable = true)
    public void onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> cir) {
        if (state.getBlock().equals(Blocks.DANDELION)) {
            if (!world.isClient()) {
                Data data = ((DataGetterInf) player).getData();
                data.increaseCarbohydrate(1);
                data.parasiteDecrease(1);
                world.breakBlock(pos, false);
                cir.setReturnValue(ActionResult.SUCCESS);
            }
        }
        cir.setReturnValue(ActionResult.FAIL);
    }
}
