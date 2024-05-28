package net.armourhud.commands;

import net.armourhud.config.config;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.armourhud.config.config.*;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class hudToggle {
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher
                .register(literal("armourhud-hudtoggle").executes(context -> {
                    if (hudEnabled) {
                        hudEnabled = false;
                    }
                    else {
                        hudEnabled = true;
                    }
                    config.writeConfig();
                    sendMessage("§aHud Enabled: %s".formatted(hudEnabled));
                    return 0;
                })));
    }

    public static void sendMessage(String txt) {
        MinecraftClient.getInstance().player.sendMessage(Text.literal(txt));
    }
}