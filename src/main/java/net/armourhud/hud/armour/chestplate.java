package net.armourhud.hud.armour;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;

import static net.armourhud.config.config.*;
import static net.armourhud.config.durabilityColourChanger.getDurabilityColour;

public class chestplate implements HudRenderCallback {
    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        ItemStack playerChestplate = MinecraftClient.getInstance().player.getInventory().armor.get(2);
        TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        if (playerChestplate != ItemStack.EMPTY && hudEnabled) {
            drawContext.drawItem(playerChestplate, xChestplateLocation, yChestplateLocation);
            int maxDurability = playerChestplate.getMaxDamage();
            int curDurability = maxDurability - playerChestplate.getDamage();
            drawContext.drawText(textRenderer, "§%s%s".formatted(getDurabilityColour(maxDurability, curDurability),curDurability), xChestplateLocation + 17, yChestplateLocation + 3, 0, false);
        }
    }
}
