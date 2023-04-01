package com.kcn.blocks.entities.chest;

import com.kcn.blocks.ModBlock;
import com.kcn.blocks.entities.ModBlockEntity;
import com.kcn.items.ModItem;
import com.kcn.screen.handler.ChestScreenHandler;
import com.kcn.util.ChestData;
import com.kcn.util.IChestData;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.UUID;

public class DChestEntity extends LootableContainerBlockEntity {
    private DefaultedList<ItemStack> inv = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private String owner;

    public static void tick(DChestEntity entity, World world, BlockPos pos) {
        if (entity.inv.get(0).getItem() == ModItem.D_CHEST_KEY) {
            entity.inv.set(0, new ItemStack(Items.AIR));
            world.setBlockState(pos, ModBlock.D_OPEN_CHEST.getDefaultState());
            PlayerEntity player = world.getPlayerByUuid(UUID.fromString(entity.owner));
            if (!world.isClient()) {
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                assert serverPlayer != null;
                ChestData.setSpawnChest(((IChestData) serverPlayer), false);
            }
        }
    }

    public DChestEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntity.D_CHEST_BLOCK_ENTITY, blockPos, blockState);
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
        return new TranslatableText("");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new ChestScreenHandler(syncId, playerInventory, this);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inv);
        nbt.putString("owner", owner);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inv);
        owner = nbt.getString("owner");
    }
}
