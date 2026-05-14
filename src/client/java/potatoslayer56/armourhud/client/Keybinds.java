package potatoslayer56.armourhud.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import potatoslayer56.armourhud.client.gui.ConfigScreen;

public class Keybinds {
  public static KeyMapping configKeybind = KeyMappingHelper.registerKeyMapping(
    new KeyMapping(
      "key.armourhud.config",
      InputConstants.Type.KEYSYM,
      GLFW.GLFW_KEY_UNKNOWN,
      KeyMapping.Category.MISC
    )
  );

  public static void register() {
    ClientTickEvents.END_CLIENT_TICK.register(client -> {
      if(configKeybind.consumeClick()){
        client.setScreen(new ConfigScreen(null));
      }
    });
  }
}
