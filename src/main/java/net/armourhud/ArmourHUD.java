package net.armourhud;

import net.armourhud.commands.*;
import net.armourhud.config.config;
import net.armourhud.hud.armour.*;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArmourHUD implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("armourhud");

	@Override
	public void onInitialize() {
		LOGGER.info("ArmourHUD Loaded");

		// CONFIG
		config.createConfig();
		config.readConfig();
		config.writeConfig();

		// COMMANDS
		registerCommands();

		// RENDER HUD
		HudRenderCallback.EVENT.register(new helmet());
		HudRenderCallback.EVENT.register(new chestplate());
		HudRenderCallback.EVENT.register(new leggings());
		HudRenderCallback.EVENT.register(new boots());
	}

	public void registerCommands() {
		helmetMove.register();
		chestplateMove.register();
		leggingsMove.register();
		bootsMove.register();
		armourMove.register();
		hudToggle.register();
	}
}