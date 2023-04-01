package com.kcn.blocks.entities.open_chest;

import com.kcn.blocks.entities.ModBlockEntity;
import com.kcn.items.ModItem;
import com.kcn.screen.handler.OpenChestHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import java.util.Random;

public class AOpenChestEntity extends LootableContainerBlockEntity {

    private DefaultedList<ItemStack> inv = DefaultedList.ofSize(5, ItemStack.EMPTY);
    private boolean is_opened = false;
    private ItemStack stack = Items.DIRT.getDefaultStack();

    public AOpenChestEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntity.A_OPEN_CHEST_ENTITY, blockPos, blockState);
    }

    public static void tick(AOpenChestEntity entity, World world, BlockPos pos) {
        if (!entity.is_opened) {
            for (int i = 0; i <= 3; i++) {
                Item item = Registry.ITEM.getRandom(new Random());
                int maxCount = item.getMaxCount();
                if (maxCount == 1) {
                    entity.stack = new ItemStack(item);
                } else {
                    entity.stack = new ItemStack(item, new Random().nextInt(1, 5));
                }
                entity.inv.set(i, entity.stack);
            }
            entity.inv.set(4, new ItemStack(ModItem.MAGIC_DUST));
            entity.is_opened = true;
        }
        if (entity.inv.isEmpty()) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
        }
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inv;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inv = list;
    }

    @Override
    protected Text getContainerName() {
        return new LiteralText("");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new OpenChestHandler(syncId, playerInventory, this);
    }

    @Override
    public int size() {
        return 5;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inv);
        is_opened = nbt.getBoolean("is_opened");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inv);
        nbt.putBoolean("is_opened", is_opened);
    }

}
