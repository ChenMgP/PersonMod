package com.kcn.items;

import com.google.gson.JsonSyntaxException;
import com.kcn.screen.handler.BagScreenHandler;
import com.kcn.screen.handler.HealthHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class BagItem extends Item {
    public BagItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.openHandledScreen(new NamedScreenHandlerFactory() {
            @Override
            public Text getDisplayName() {
                return new LiteralText("");
            }

            @Override
            public @NotNull ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                Inventory inventory = new SimpleInventory(27);
                if (player.getMainHandStack().hasNbt()) {
                    NbtList items = (NbtList) Objects.requireNonNull(player.getMainHandStack().getNbt()).get("items");
                    for (int i = 0; i < Objects.requireNonNull(items).size(); i++) {
                        NbtCompound item = items.getCompound(i);
                        int hasNbt = item.getInt("has_nbt");
                        if (hasNbt == 0) {
                            int count = item.getInt("count");
                            String id = item.getString("id");
                            Item item1 = Registry.ITEM.getOrEmpty(new Identifier(id)).orElseThrow(() -> new JsonSyntaxException("No such item" + id));
                            ItemStack stack = new ItemStack(item1, count);
                            inventory.setStack(i, stack);
                        } else if (hasNbt == 1) {
                            NbtCompound nbt = item.getCompound("nbt");
                            int count = item.getInt("count");
                            String id = item.getString("id");
                            Item item1 = Registry.ITEM.getOrEmpty(new Identifier(id)).orElseThrow(() -> new JsonSyntaxException("No such item" + id));
                            ItemStack stack = new ItemStack(item1, count);
                            stack.setNbt(nbt);
                            inventory.setStack(i, stack);
                        }
                    }
                    return new BagScreenHandler(syncId, inv, inventory);
                } else {
                    return new BagScreenHandler(syncId, inv);
                }
            }
        });
        return super.use(world, user, hand);
    }

}
