package net.armourhud.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.armourhud.config.config;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.armourhud.config.config.*;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class helmetMove {
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher
        .register(literal("armourhud-helmetmovex").then(argument("new-x", IntegerArgumentType.integer()).executes(context -> {
            xHelmetLocation = IntegerArgumentType.getInteger(context,"new-x");
            config.writeConfig();
            sendMessage("§aHelmet HUD Location: %s,%s".formatted(xHelmetLocation,yHelmetLocation));
            return 0;
        }))));
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher
        .register(literal("armourhud-helmetmovey").then(argument("new-y", IntegerArgumentType.integer()).executes(context -> {
            yHelmetLocation = IntegerArgumentType.getInteger(context,"new-y");
            config.writeConfig();
            sendMessage("§aHelmet HUD Location: %s,%s".formatted(xHelmetLocation,yHelmetLocation));
            return 0;
        }))));
    }

    public static void sendMessage(String txt) {
        MinecraftClient.getInstance().player.sendMessage(Text.literal(txt));
    }
}
