package com.kcn.items;

import com.kcn.util.Data;
import com.kcn.util.DataGetterInf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WaterBag extends Item {
    public WaterBag(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack mainHandStack = user.getMainHandStack();
        if (mainHandStack.hasNbt()) {
            assert mainHandStack.getNbt() != null;
            int amount = mainHandStack.getNbt().getInt("amount");
            Data data = ((DataGetterInf) user).getData();
            int water = data.getWater();
            NbtCompound nbt = new NbtCompound();
            if (water != 20 && amount < 0) {
                if (20 - water <= amount) {
                    int a = 20 - water;
                    int b = amount - a;
                    nbt.putInt("amount", b);
                    NbtCompound nbt1 = new NbtCompound();
                    NbtString string = NbtString.of(NbtString.escape("§f§l剩余水量: §b" + b));
                    NbtList list = new NbtList();
                    list.add(string);
                    nbt1.put("Lore", list);
                    nbt.put("display", nbt1);
                    data.increase(20);
                    data.reloadTime();
                } else {
                    nbt.putInt("amount", 0);
                    NbtCompound nbt1 = new NbtCompound();
                    NbtString string = NbtString.of(NbtString.escape("§f§l剩余水量: §b0"));
                    NbtList list = new NbtList();
                    list.add(string);
                    nbt1.put("Lore", list);
                    nbt.put("display", nbt1);
                    data.increase(amount);
                    data.reloadTime();
                }
                mainHandStack.setNbt(nbt);
            }
        }
        return super.use(world, user, hand);
    }
}
