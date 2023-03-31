package com.kcn.blocks.entities.chest;

import com.kcn.blocks.entities.ModBlockEntity;
import com.kcn.screen.handler.AChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class AChestEntity extends LootableContainerBlockEntity {

    private String owner;
    private DefaultedList<ItemStack> inv = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public AChestEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.A_CHEST_BLOCK_ENTITY, pos, state);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
        return new AChestScreenHandler(syncId, playerInventory);
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inv);
        owner = nbt.getString("owner");
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inv);
        nbt.putString("owner", owner);
    }
}
