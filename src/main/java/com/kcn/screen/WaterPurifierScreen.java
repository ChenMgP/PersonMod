package com.kcn.screen;

import com.kcn.screen.handler.WaterPurifierScreenHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WaterPurifierScreen extends HandledScreen<WaterPurifierScreenHandler> {

    private static final Identifier TEXTURE = new Identifier("kcn", "textures/gui/container/water_purifier.png");

    public WaterPurifierScreen(WaterPurifierScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.passEvents = false;
        this.backgroundHeight = 167;
        this.playerInventoryTitleY = this.backgroundHeight - 94;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = this.x;
        int j = this.y;
        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int water = handler.getWater();
        int coal = handler.getCoal();
        int time = handler.getTime() / 20;
        if (water > 0 && water <= 5) {
            this.drawTexture(matrices, i + 45, j + 35, 176, 7, (water * 10 + 1), 7);
        }
        if (coal == 1) {
            this.drawTexture(matrices, i + 78, j + 21, 177, 1, 9, 5);
        } else if (coal == 2) {
            this.drawTexture(matrices, i + 78, j + 21, 177, 1, 9, 5);
            this.drawTexture(matrices, i + 68, j + 21, 177, 1, 9, 5);
        } else if (coal == 3) {
            this.drawTexture(matrices, i + 78, j + 21, 177, 1, 9, 5);
            this.drawTexture(matrices, i + 68, j + 21, 177, 1, 9, 5);
            this.drawTexture(matrices, i + 58, j + 21, 177, 1, 9, 5);
        }
        if (time > 0) {
            this.drawTexture(matrices, i + 33, j + 47, 176, 14, 4, time * 3);
        }
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

}
