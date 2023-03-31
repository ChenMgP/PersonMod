package com.kcn.blocks.entities;

import com.kcn.blocks.ModBlock;
import com.kcn.blocks.entities.chest.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntity {

    public static BlockEntityType<WaterPurifierBlockEntity> WATER_PURIFIER_BLOCK_ENTITY;
    public static BlockEntityType<CisternEntity> CISTERN_BLOCK_ENTITY;
    public static BlockEntityType<BirchCisternEntity> BIRCH_CISTERN_BLOCK_ENTITY;
    public static BlockEntityType<JungleCisternEntity> JUNGLE_CISTERN_BLOCK_ENTITY;
    public static BlockEntityType<AcaciaCisternEntity> ACACIA_CISTERN_BLOCK_ENTITY;
    public static BlockEntityType<SpruceCisternEntity> SPRUCE_CISTERN_BLOCK_ENTITY;
    public static BlockEntityType<DarkOakCisternEntity> DARK_OAK_CISTERN_BLOCK_ENTITY;
    public static BlockEntityType<AChestEntity> A_CHEST_BLOCK_ENTITY;
    public static BlockEntityType<BChestEntity> B_CHEST_BLOCK_ENTITY;
    public static BlockEntityType<CChestEntity> C_CHEST_BLOCK_ENTITY;
    public static BlockEntityType<DChestEntity> D_CHEST_BLOCK_ENTITY;
    public static BlockEntityType<EChestEntity> E_CHEST_BLOCK_ENTITY;


    public static void init() {
        A_CHEST_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "a_chest"), FabricBlockEntityTypeBuilder.create(AChestEntity::new, ModBlock.A_CHEST).build());
        B_CHEST_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "b_chest"), FabricBlockEntityTypeBuilder.create(BChestEntity::new, ModBlock.B_CHEST).build());
        C_CHEST_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "c_chest"), FabricBlockEntityTypeBuilder.create(CChestEntity::new, ModBlock.C_CHEST).build());
        D_CHEST_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "d_chest"), FabricBlockEntityTypeBuilder.create(DChestEntity::new, ModBlock.D_CHEST).build());
        E_CHEST_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "e_chest"), FabricBlockEntityTypeBuilder.create(EChestEntity::new, ModBlock.E_CHEST).build());
        WATER_PURIFIER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "water_purifier"), FabricBlockEntityTypeBuilder.create(WaterPurifierBlockEntity::new, ModBlock.WATER_PURIFIER).build());
        CISTERN_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "cistern"), FabricBlockEntityTypeBuilder.create(CisternEntity::new, ModBlock.CISTERN).build());
        BIRCH_CISTERN_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "birch_cistern"), FabricBlockEntityTypeBuilder.create(BirchCisternEntity::new, ModBlock.BIRCH_CISTERN).build());
        JUNGLE_CISTERN_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "jungle_cistern"), FabricBlockEntityTypeBuilder.create(JungleCisternEntity::new, ModBlock.JUNGLE_CISTERN).build());
        ACACIA_CISTERN_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "acacia_cistern"), FabricBlockEntityTypeBuilder.create(AcaciaCisternEntity::new, ModBlock.ACACIA_CISTERN).build());
        SPRUCE_CISTERN_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "spruce_cistern"), FabricBlockEntityTypeBuilder.create(SpruceCisternEntity::new, ModBlock.SPRUCE_CISTERN).build());
        DARK_OAK_CISTERN_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("kcn", "dark_oak_cistern"), FabricBlockEntityTypeBuilder.create(DarkOakCisternEntity::new, ModBlock.DARK_OAK_CISTERN).build());
    }

}
