package com.kcn.mixin;

import com.kcn.util.Data;
import com.kcn.util.DataGetterInf;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CakeBlock.class)
public class CakeMixin {

    @Inject(at = @At("TAIL"), method = "tryEat", cancellable = true)
    private static void tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfoReturnable<ActionResult> cir) {
        Data data = ((DataGetterInf) player).getData();
        data.increaseCarbohydrate(10);
        data.tickSpeed(145);
        cir.setReturnValue(ActionResult.SUCCESS);
    }
}
