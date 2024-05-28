package net.armourhud.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.armourhud.config.config;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import static net.armourhud.config.config.*;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.argument;
import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.literal;

public class armourMove {
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher
        .register(literal("armourhud-movex").then(argument("new-x", IntegerArgumentType.integer()).executes(context -> {
            xHelmetLocation = IntegerArgumentType.getInteger(context, "new-x");
            xChestplateLocation = IntegerArgumentType.getInteger(context, "new-x");
            xLeggingsLocation = IntegerArgumentType.getInteger(context, "new-x");
            xBootsLocation = IntegerArgumentType.getInteger(context, "new-x");
            config.writeConfig();
            return 0;
        }))));
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher
        .register(literal("armourhud-movey").then(argument("new-y", IntegerArgumentType.integer()).executes(context -> {
            yHelmetLocation = IntegerArgumentType.getInteger(context, "new-y");
            yChestplateLocation = IntegerArgumentType.getInteger(context, "new-y") + 20;
            yLeggingsLocation = IntegerArgumentType.getInteger(context, "new-y") + 40;
            yBootsLocation = IntegerArgumentType.getInteger(context, "new-y") + 60;
            config.writeConfig();
            return 0;
        }))));
    }

    public static void sendMessage(String txt) {
        MinecraftClient.getInstance().player.sendMessage(Text.literal(txt));
    }
}
