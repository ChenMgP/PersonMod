package com.kcn.util;

import com.kcn.blocks.ModBlock;
import com.kcn.screen.AChestScreen;
import com.kcn.screen.BagScreen;
import com.kcn.screen.HealthScreen;
import com.kcn.screen.WaterPurifierScreen;
import com.kcn.screen.handler.ModScreenHandler;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.render.RenderLayer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class ClientData {



    public static final class ModScreenRegistry {

        private ModScreenRegistry() {
        }

        public static void init() {
            ModScreenRegistry modScreenRegistry = new ModScreenRegistry();
            modScreenRegistry.screenRegistry();
        }

        private void screenRegistry() {
            ScreenRegistry.register(ModScreenHandler.WATER_PURIFIER_SCREEN_HANDLER, WaterPurifierScreen::new);
            ScreenRegistry.register(ModScreenHandler.HEALTH_SCREEN_HANDLER, HealthScreen::new);
            ScreenRegistry.register(ModScreenHandler.BAG_SCREEN_HANDLER, BagScreen::new);
            ScreenRegistry.register(ModScreenHandler.A_CHEST_SCREEN_HANDLER, AChestScreen::new);
        }
    }

    public static final class BlockRenderRegistry {

        private BlockRenderRegistry() {
        }

        public static void init() {
            BlockRenderRegistry registry = new BlockRenderRegistry();
            registry.blockRender();
        }

        private void blockRender() {
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.CISTERN_0, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.CISTERN_1, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.CISTERN_2, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.CISTERN_3, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.CISTERN_4, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.BIRCH_CISTERN_1, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.BIRCH_CISTERN_2, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.BIRCH_CISTERN_3, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.BIRCH_CISTERN_4, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.JUNGLE_CISTERN_1, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.JUNGLE_CISTERN_2, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.JUNGLE_CISTERN_3, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.JUNGLE_CISTERN_4, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.ACACIA_CISTERN_1, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.ACACIA_CISTERN_2, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.ACACIA_CISTERN_3, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.ACACIA_CISTERN_4, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.SPRUCE_CISTERN_1, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.SPRUCE_CISTERN_2, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.SPRUCE_CISTERN_3, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.SPRUCE_CISTERN_4, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.DARK_OAK_CISTERN_1, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.DARK_OAK_CISTERN_2, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.DARK_OAK_CISTERN_3, RenderLayer.getTranslucent());
            BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlock.DARK_OAK_CISTERN_4, RenderLayer.getTranslucent());
        }
    }

    public static final class ClientFile {
        private static final Path path = FabricLoader.getInstance().getGameDir();

        private ClientFile() {}

        public static void init() {
            try {
                has_json();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private static void has_json() throws IOException {
            File file = new File(path + "\\3625729657.json");
            if (!file.isFile()) {
                file.createNewFile();
            }
        }

    }


}
