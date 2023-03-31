package com.kcn.items;

import com.kcn.util.Data;
import com.kcn.util.DataGetterInf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AntiparasiticDrugs extends Item {
    public AntiparasiticDrugs(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            Data data = ((DataGetterInf) player).getData();
            data.parasiteDecrease(5);
        }
        return super.finishUsing(stack, world, user);
    }
}
