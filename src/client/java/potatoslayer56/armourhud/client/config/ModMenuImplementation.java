package potatoslayer56.armourhud.client.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import potatoslayer56.armourhud.client.gui.ConfigScreen;

public class ModMenuImplementation implements ModMenuApi {
  @Override
  public ConfigScreenFactory<?> getModConfigScreenFactory() {
    return ConfigScreen::new;
  }
}
