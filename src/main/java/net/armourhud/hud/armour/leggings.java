package net.armourhud.hud.armour;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

import static net.armourhud.config.config.*;
import static net.armourhud.config.durabilityColourChanger.getDurabilityColour;

public class leggings implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        ItemStack playerLeggings = MinecraftClient.getInstance().player.getInventory().armor.get(1);
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        if (playerLeggings != ItemStack.EMPTY && hudEnabled) {
            drawContext.drawItem(playerLeggings, xLeggingsLocation, yLeggingsLocation);
            int maxDurability = playerLeggings.getMaxDamage();
            int curDurability = maxDurability - playerLeggings.getDamage();
            drawContext.drawText(textRenderer, "§%s%s".formatted(getDurabilityColour(maxDurability, curDurability),curDurability), xLeggingsLocation + 17, yLeggingsLocation + 3, 0, false);
        }
    }
}
