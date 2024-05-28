package net.armourhud.hud.armour;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

import static net.armourhud.config.config.*;
import static net.armourhud.config.durabilityColourChanger.getDurabilityColour;

public class helmet implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        ItemStack playerHelmet = MinecraftClient.getInstance().player.getInventory().armor.get(3);
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        if (playerHelmet != ItemStack.EMPTY && hudEnabled) {
            drawContext.drawItem(playerHelmet,xHelmetLocation,yHelmetLocation);
            int maxDurability = playerHelmet.getMaxDamage();
            int curDurability = maxDurability - playerHelmet.getDamage();
            drawContext.drawText(textRenderer, "§%s%s".formatted(getDurabilityColour(maxDurability, curDurability),curDurability),xHelmetLocation+17,yHelmetLocation+3,0,false);
        }
    }
}
