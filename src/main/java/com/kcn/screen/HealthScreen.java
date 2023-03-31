package com.kcn.screen;

import com.kcn.screen.handler.HealthHandler;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HealthScreen extends HandledScreen<HealthHandler> {

    private static final Identifier TEXTURE = new Identifier("kcn", "textures/gui/health.png");

    public HealthScreen(HealthHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, new LiteralText(""));
        this.passEvents = false;
        this.backgroundHeight = 111;
        this.backgroundWidth = 176;
        this.playerInventoryTitleX = -100000;
        this.playerInventoryTitleY = -100000;
    }

    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = this.x;
        int j = this.y;
        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        String water = this.handler.getWater();
        if (this.handler.hasParasite()) {
            String parasite = this.handler.getParasite();
            this.textRenderer.draw(matrices, "水分值: " + water +" /20", i + 39.0f, j + 34.0f, 0x7ad8d5);
            this.textRenderer.draw(matrices, "寄生虫: " + parasite, i + 39.0f, j + 43.5f, 0xd87a7a);
        } else {
            this.textRenderer.draw(matrices, "水分值: " + water + "/20", i + 39.0f, j + 34.0f, 0x7ad8d5);
        }
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
    }

}
