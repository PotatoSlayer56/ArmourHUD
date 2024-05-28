package net.armourhud.hud.armour;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

import static net.armourhud.config.config.*;
import static net.armourhud.config.durabilityColourChanger.*;

public class boots implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        ItemStack playerBoots = MinecraftClient.getInstance().player.getInventory().armor.get(0);
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        if (playerBoots != ItemStack.EMPTY && hudEnabled) {
            drawContext.drawItem(playerBoots, xBootsLocation, yBootsLocation);
            int maxDurability = playerBoots.getMaxDamage();
            int curDurability = maxDurability - playerBoots.getDamage();
            drawContext.drawText(textRenderer, "§%s%s".formatted(getDurabilityColour(maxDurability, curDurability),curDurability), xBootsLocation + 17, yBootsLocation + 3, 0, false);
        }
    }
}
