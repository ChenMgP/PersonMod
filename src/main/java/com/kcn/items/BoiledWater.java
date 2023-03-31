package com.kcn.items;

import com.kcn.util.Data;
import com.kcn.util.DataGetterInf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class BoiledWater extends PotionItem {
    public BoiledWater(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof PlayerEntity player) {
            Data data = ((DataGetterInf) player).getData();
            data.reloadTime();
            data.increase(2);
            return new ItemStack(Items.GLASS_BOTTLE);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> stacks) {
        if (this.isIn(group)) {
            stacks.add(new ItemStack(this));
        }
    }
}
