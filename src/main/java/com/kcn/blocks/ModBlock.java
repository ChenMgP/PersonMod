package com.kcn.blocks;

import com.kcn.blocks.chest.*;
import com.kcn.blocks.cistern.*;
import com.kcn.blocks.cistern.acacia.AcaciaCistern1;
import com.kcn.blocks.cistern.acacia.AcaciaCistern2;
import com.kcn.blocks.cistern.acacia.AcaciaCistern3;
import com.kcn.blocks.cistern.acacia.AcaciaCistern4;
import com.kcn.blocks.cistern.birch.BirchCistern1;
import com.kcn.blocks.cistern.birch.BirchCistern2;
import com.kcn.blocks.cistern.birch.BirchCistern3;
import com.kcn.blocks.cistern.birch.BirchCistern4;
import com.kcn.blocks.cistern.dark_oak.DarkOakCistern1;
import com.kcn.blocks.cistern.dark_oak.DarkOakCistern2;
import com.kcn.blocks.cistern.dark_oak.DarkOakCistern3;
import com.kcn.blocks.cistern.dark_oak.DarkOakCistern4;
import com.kcn.blocks.cistern.jungle.JungleCistern1;
import com.kcn.blocks.cistern.jungle.JungleCistern2;
import com.kcn.blocks.cistern.jungle.JungleCistern3;
import com.kcn.blocks.cistern.jungle.JungleCistern4;
import com.kcn.blocks.cistern.oak.Cistern1;
import com.kcn.blocks.cistern.oak.Cistern2;
import com.kcn.blocks.cistern.oak.Cistern3;
import com.kcn.blocks.cistern.oak.Cistern4;
import com.kcn.blocks.cistern.sqruce.SpruceCistern1;
import com.kcn.blocks.cistern.sqruce.SpruceCistern2;
import com.kcn.blocks.cistern.sqruce.SpruceCistern3;
import com.kcn.blocks.cistern.sqruce.SpruceCistern4;
import com.kcn.items.ModItem;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class ModBlock {

    public static final Block CISTERN_0 = ModBlock.registerHiddenBlock("oak_cistern_0", new Cistern0(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block CISTERN_1 = ModBlock.registerHiddenBlock("oak_cistern_1", new Cistern1(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block CISTERN_2 = ModBlock.registerHiddenBlock("oak_cistern_2", new Cistern2(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block CISTERN_3 = ModBlock.registerHiddenBlock("oak_cistern_3", new Cistern3(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block CISTERN_4 = ModBlock.registerHiddenBlock("oak_cistern_4", new Cistern4(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block BIRCH_CISTERN_1 = ModBlock.registerHiddenBlock("birch_cistern_1", new BirchCistern1(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block BIRCH_CISTERN_2 = ModBlock.registerHiddenBlock("birch_cistern_2", new BirchCistern2(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block BIRCH_CISTERN_3 = ModBlock.registerHiddenBlock("birch_cistern_3", new BirchCistern3(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block BIRCH_CISTERN_4 = ModBlock.registerHiddenBlock("birch_cistern_4", new BirchCistern4(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block JUNGLE_CISTERN_1 = ModBlock.registerHiddenBlock("jungle_cistern_1", new JungleCistern1(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block JUNGLE_CISTERN_2 = ModBlock.registerHiddenBlock("jungle_cistern_2", new JungleCistern2(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block JUNGLE_CISTERN_3 = ModBlock.registerHiddenBlock("jungle_cistern_3", new JungleCistern3(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block JUNGLE_CISTERN_4 = ModBlock.registerHiddenBlock("jungle_cistern_4", new JungleCistern4(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block ACACIA_CISTERN_1 = ModBlock.registerHiddenBlock("acacia_cistern_1", new AcaciaCistern1(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block ACACIA_CISTERN_2 = ModBlock.registerHiddenBlock("acacia_cistern_2", new AcaciaCistern2(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block ACACIA_CISTERN_3 = ModBlock.registerHiddenBlock("acacia_cistern_3", new AcaciaCistern3(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block ACACIA_CISTERN_4 = ModBlock.registerHiddenBlock("acacia_cistern_4", new AcaciaCistern4(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block SPRUCE_CISTERN_1 = ModBlock.registerHiddenBlock("spruce_cistern_1", new SpruceCistern1(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block SPRUCE_CISTERN_2 = ModBlock.registerHiddenBlock("spruce_cistern_2", new SpruceCistern2(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block SPRUCE_CISTERN_3 = ModBlock.registerHiddenBlock("spruce_cistern_3", new SpruceCistern3(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block SPRUCE_CISTERN_4 = ModBlock.registerHiddenBlock("spruce_cistern_4", new SpruceCistern4(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block DARK_OAK_CISTERN_1 = ModBlock.registerHiddenBlock("dark_oak_cistern_1", new DarkOakCistern1(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block DARK_OAK_CISTERN_2 = ModBlock.registerHiddenBlock("dark_oak_cistern_2", new DarkOakCistern2(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block DARK_OAK_CISTERN_3 = ModBlock.registerHiddenBlock("dark_oak_cistern_3", new DarkOakCistern3(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block DARK_OAK_CISTERN_4 = ModBlock.registerHiddenBlock("dark_oak_cistern_4", new DarkOakCistern4(AbstractBlock.Settings.of(Material.GLASS).strength(-1.0f, 3600000.0f).nonOpaque().noCollision().dropsNothing().allowsSpawning(ModBlock::never)));
    public static final Block MACHINE_FRAME = ModBlock.register("machine_frame", new Block(AbstractBlock.Settings.of(Material.METAL).strength(3f)));
    public static final Block WATER_PURIFIER = ModBlock.register("water_purifier", new WaterPurifier(AbstractBlock.Settings.of(Material.METAL).strength(3f)));
    public static final Block CISTERN = ModBlock.register("oak_cistern", new Cistern(AbstractBlock.Settings.of(Material.WOOD).nonOpaque().strength(1f)));
    public static final Block BIRCH_CISTERN = ModBlock.register("birch_cistern", new BirchCistern(AbstractBlock.Settings.of(Material.WOOD).nonOpaque().strength(1f)));
    public static final Block JUNGLE_CISTERN = ModBlock.register("jungle_cistern", new JungleCistern(AbstractBlock.Settings.of(Material.WOOD).nonOpaque().strength(1f)));
    public static final Block ACACIA_CISTERN = ModBlock.register("acacia_cistern", new AcaciaCistern(AbstractBlock.Settings.of(Material.WOOD).nonOpaque().strength(1f)));
    public static final Block SPRUCE_CISTERN = ModBlock.register("spruce_cistern", new SpruceCistern(AbstractBlock.Settings.of(Material.WOOD).nonOpaque().strength(1f)));
    public static final Block DARK_OAK_CISTERN = ModBlock.register("dark_oak_cistern", new DarkOakCistern(AbstractBlock.Settings.of(Material.WOOD).nonOpaque().strength(1f)));
    public static final Block A_CHEST = ModBlock.registerHiddenBlock("a_chest", new AChest(AbstractBlock.Settings.of(Material.METAL).strength(-1.0f, 3600000.0f).allowsSpawning(ModBlock::never)));
    public static final Block B_CHEST = ModBlock.registerHiddenBlock("b_chest", new BChest(AbstractBlock.Settings.of(Material.METAL).strength(-1.0f, 3600000.0f).allowsSpawning(ModBlock::never)));
    public static final Block C_CHEST = ModBlock.registerHiddenBlock("c_chest", new CChest(AbstractBlock.Settings.of(Material.METAL).strength(-1.0f, 3600000.0f).allowsSpawning(ModBlock::never)));
    public static final Block D_CHEST = ModBlock.registerHiddenBlock("d_chest", new DChest(AbstractBlock.Settings.of(Material.METAL).strength(-1.0f, 3600000.0f).allowsSpawning(ModBlock::never)));
    public static final Block E_CHEST = ModBlock.registerHiddenBlock("e_chest", new EChest(AbstractBlock.Settings.of(Material.METAL).strength(-1.0f, 3600000.0f).allowsSpawning(ModBlock::never)));

    public static void block() {
    }

    private static Block register(String name, Block entry) {
        Registry.register(Registry.ITEM, new Identifier("kcn", name), new BlockItem(entry, new Item.Settings().group(ModItem.Group.WATER_GROUP)));
        return Registry.register(Registry.BLOCK, new Identifier("kcn", name), entry);
    }

    private static Block registerHiddenBlock(String name, Block entry) {
        return Registry.register(Registry.BLOCK, new Identifier("kcn", name), entry);
    }

    private static boolean never(BlockState state, BlockView blockView, BlockPos pos, EntityType<?> entityType) {
        return false;
    }

    private static boolean never(BlockState state, BlockView blockView, BlockPos pos) {
        return false;
    }

}
