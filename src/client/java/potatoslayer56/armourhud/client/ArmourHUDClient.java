package potatoslayer56.armourhud.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.resources.Identifier;
import potatoslayer56.armourhud.ArmourHUD;
import potatoslayer56.armourhud.client.config.Config;
import potatoslayer56.armourhud.client.config.SaveLoad;
import potatoslayer56.armourhud.client.hud.armour;

public class ArmourHUDClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Config.initialise();

		SaveLoad.createConfig();
		SaveLoad.loadConfig();

		Keybinds.register();

		registerHudElements();
	}

	public static int getDurabilityColour(int maxDurability, int durability){
		if(durability == 0 || maxDurability == 0){
			return 0xFFFFFF;
		}
		if((double) durability / maxDurability <= 0.1){
			return 0xFF3C12;
		}
		else if((double) durability / maxDurability <= 0.4){
			return 0xFCA40A;
		}
		else if((double) durability / maxDurability <= 0.6){
			return 0xF3F716;
		}
		return 0x55F716;
	}

	private static void registerHudElements(){
		HudElementRegistry.addLast(Identifier.fromNamespaceAndPath(ArmourHUD.MOD_ID, "armour"), new armour());
	}
}