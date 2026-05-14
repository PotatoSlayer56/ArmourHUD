package potatoslayer56.armourhud.client.hud;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import potatoslayer56.armourhud.client.ArmourHUDClient;
import potatoslayer56.armourhud.client.config.Config;

public class armour implements HudElement {

  @Override
  public void extractRenderState(GuiGraphicsExtractor guiGraphicsExtractor, DeltaTracker deltaTracker) {
    Minecraft instance = Minecraft.getInstance();
    LocalPlayer player = instance.player;

    ItemStack playerHelmet = ItemStack.EMPTY;
    ItemStack playerChestplate = ItemStack.EMPTY;
    ItemStack playerLeggings = ItemStack.EMPTY;
    ItemStack playerBoots = ItemStack.EMPTY;

    if (player != null) {
      playerHelmet = player.getInventory().getItem(39);
      playerChestplate = player.getInventory().getItem(38);
      playerLeggings = player.getInventory().getItem(37);
      playerBoots = player.getInventory().getItem(36);
    }

    if(Config.helmetConfig.isEnabled() && playerHelmet != ItemStack.EMPTY){
      guiGraphicsExtractor.item(
        playerHelmet,
        Config.helmetConfig.getXPos(),
        Config.helmetConfig.getYPos()
      );
      guiGraphicsExtractor.textRenderer().accept(
        Config.helmetConfig.getXPos() + 16,
        Config.helmetConfig.getYPos() + 4,
        Component.literal(String.valueOf(playerHelmet.getMaxDamage() - playerHelmet.getDamageValue()))
          .withColor(ArmourHUDClient.getDurabilityColour(playerHelmet.getMaxDamage(),playerHelmet.getMaxDamage() - playerHelmet.getDamageValue()))
      );
    }

    if(Config.chestplateConfig.isEnabled() && playerChestplate != ItemStack.EMPTY){
      guiGraphicsExtractor.item(
        playerChestplate,
        Config.chestplateConfig.getXPos(),
        Config.chestplateConfig.getYPos()
      );
      guiGraphicsExtractor.textRenderer().accept(
        Config.chestplateConfig.getXPos() + 16,
        Config.chestplateConfig.getYPos() + 4,
        Component.literal(String.valueOf(playerChestplate.getMaxDamage() - playerChestplate.getDamageValue()))
          .withColor(ArmourHUDClient.getDurabilityColour(playerChestplate.getMaxDamage(),playerChestplate.getMaxDamage() - playerChestplate.getDamageValue()))
      );
    }

    if(Config.leggingsConfig.isEnabled() && playerLeggings != ItemStack.EMPTY){
      guiGraphicsExtractor.item(
        playerLeggings,
        Config.leggingsConfig.getXPos(),
        Config.leggingsConfig.getYPos()
      );
      guiGraphicsExtractor.textRenderer().accept(
        Config.leggingsConfig.getXPos() + 16,
        Config.leggingsConfig.getYPos() + 4,
        Component.literal(String.valueOf(playerLeggings.getMaxDamage() - playerLeggings.getDamageValue()))
          .withColor(ArmourHUDClient.getDurabilityColour(playerLeggings.getMaxDamage(),playerLeggings.getMaxDamage() - playerLeggings.getDamageValue()))
      );
    }

    if(Config.bootsConfig.isEnabled() && playerBoots != ItemStack.EMPTY){
      guiGraphicsExtractor.item(
        playerBoots,
        Config.bootsConfig.getXPos(),
        Config.bootsConfig.getYPos()
      );
      guiGraphicsExtractor.textRenderer().accept(
        Config.bootsConfig.getXPos() + 16,
        Config.bootsConfig.getYPos() + 4,
        Component.literal(String.valueOf(playerBoots.getMaxDamage() - playerBoots.getDamageValue()))
          .withColor(ArmourHUDClient.getDurabilityColour(playerBoots.getMaxDamage(),playerBoots.getMaxDamage() - playerBoots.getDamageValue()))
      );
    }
  }
}
