package potatoslayer56.armourhud.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.Nullable;
import potatoslayer56.armourhud.client.config.Config;
import potatoslayer56.armourhud.client.config.SaveLoad;

public class ConfigScreen extends Screen {
  private final @Nullable Screen parent;

  public ConfigScreen(@Nullable Screen parent) {
    super(Component.translatable("config.armourhud.screen.title"));
    this.parent = parent;
  }

  @Override
  protected void init() {
    int guiScale;
    int windowWidth = Minecraft.getInstance().getWindow().getWidth();
    int windowHeight = Minecraft.getInstance().getWindow().getHeight();

    if(Minecraft.getInstance().options.guiScale().get() != 0){
      guiScale = Minecraft.getInstance().options.guiScale().get();
    }
    else {
      guiScale = 4;
    }

    int textBoxWidth = windowWidth / (8 * guiScale);
    int textBoxOffset = this.font.width(Component.translatable("config.armourhud.screen.label.chestplateposition")) + 15;

    EditBox helmetXPositionInput = new EditBox(
      this.font,
      textBoxOffset,
      36,
      textBoxWidth,
      16,
      Component.translatable("config.armourhud.screen.placeholder.helmetposition")
    );
    helmetXPositionInput.setValue(String.valueOf(Config.helmetConfig.getXPos()));

    EditBox helmetYPositionInput = new EditBox(
      this.font,
      textBoxOffset + 15 + textBoxWidth,
      36,
      textBoxWidth,
      16,
      Component.translatable("config.armourhud.screen.placeholder.helmetposition")
    );
    helmetYPositionInput.setValue(String.valueOf(Config.helmetConfig.getYPos()));

    Checkbox helmetToggle = Checkbox
      .builder(Component.literal(""), this.font)
      .pos(textBoxOffset + (2 * textBoxWidth) + 30, 36)
      .selected(Config.helmetConfig.isEnabled())
      .onValueChange(((checkbox, value) -> {
        Config.helmetConfig.setEnabled(value);
      }))
      .build();

    EditBox chestplateXPositionInput = new EditBox(
      this.font,
      textBoxOffset,
      56,
      textBoxWidth,
      16,
      Component.translatable("config.armourhud.screen.placeholder.chestplateposition")
    );
    chestplateXPositionInput.setValue(String.valueOf(Config.chestplateConfig.getXPos()));

    EditBox chestplateYPositionInput = new EditBox(
      this.font,
      textBoxOffset + 15 + textBoxWidth,
      56,
      textBoxWidth,
      16,
      Component.translatable("config.armourhud.screen.placeholder.chestplateposition")
    );
    chestplateYPositionInput.setValue(String.valueOf(Config.chestplateConfig.getYPos()));

    Checkbox chestplateToggle = Checkbox
      .builder(Component.literal(""), this.font)
      .pos(textBoxOffset + (2 * textBoxWidth) + 30, 56)
      .selected(Config.chestplateConfig.isEnabled())
      .onValueChange(((checkbox, value) -> {
        Config.chestplateConfig.setEnabled(value);
      }))
      .build();

    EditBox leggingsXPositionInput = new EditBox(
      this.font,
      textBoxOffset,
      76,
      textBoxWidth,
      16,
      Component.translatable("config.armourhud.screen.placeholder.leggingsposition")
    );
    leggingsXPositionInput.setValue(String.valueOf(Config.leggingsConfig.getXPos()));

    EditBox leggingsYPositionInput = new EditBox(
      this.font,
      textBoxOffset + 15 + textBoxWidth,
      76,
      textBoxWidth,
      16,
      Component.translatable("config.armourhud.screen.placeholder.leggingsposition")
    );
    leggingsYPositionInput.setValue(String.valueOf(Config.leggingsConfig.getYPos()));

    Checkbox leggingsToggle = Checkbox
      .builder(Component.literal(""), this.font)
      .pos(textBoxOffset + (2 * textBoxWidth) + 30, 76)
      .selected(Config.leggingsConfig.isEnabled())
      .onValueChange(((checkbox, value) -> {
        Config.leggingsConfig.setEnabled(value);
      }))
      .build();


    EditBox bootsXPositionInput = new EditBox(
      this.font,
      textBoxOffset,
      96,
      textBoxWidth,
      16,
      Component.translatable("config.armourhud.screen.placeholder.bootsposition")
    );
    bootsXPositionInput.setValue(String.valueOf(Config.bootsConfig.getXPos()));

    EditBox bootsYPositionInput = new EditBox(
      this.font,
      textBoxOffset + 15 + textBoxWidth,
      96,
      textBoxWidth,
      16,
      Component.translatable("config.armourhud.screen.placeholder.bootsposition")
    );
    bootsYPositionInput.setValue(String.valueOf(Config.bootsConfig.getYPos()));

    Checkbox bootsToggle = Checkbox
      .builder(Component.literal(""), this.font)
      .pos(textBoxOffset + (2 * textBoxWidth) + 30, 96)
      .selected(Config.bootsConfig.isEnabled())
      .onValueChange(((checkbox, value) -> {
        Config.bootsConfig.setEnabled(value);
      }))
      .build();

    Button saveAndQuitButton = Button.builder(Component.translatable("config.armourhud.screen.button.save"), (button -> {
      Config.helmetConfig.setXPos(Integer.parseInt(helmetXPositionInput.getValue()));
      Config.helmetConfig.setYPos(Integer.parseInt(helmetYPositionInput.getValue()));
      Config.chestplateConfig.setXPos(Integer.parseInt(chestplateXPositionInput.getValue()));
      Config.chestplateConfig.setYPos(Integer.parseInt(chestplateYPositionInput.getValue()));
      Config.leggingsConfig.setXPos(Integer.parseInt(leggingsXPositionInput.getValue()));
      Config.leggingsConfig.setYPos(Integer.parseInt(leggingsYPositionInput.getValue()));
      Config.bootsConfig.setXPos(Integer.parseInt(bootsXPositionInput.getValue()));
      Config.bootsConfig.setYPos(Integer.parseInt(bootsYPositionInput.getValue()));
      SaveLoad.saveConfig();
      Minecraft.getInstance().setScreen(parent);
    }))
      .bounds(
        10,
        126,
        this.font.width(Component.translatable("config.armourhud.screen.button.save")) + 16,
        this.font.lineHeight + 16)
      .build();

    this.addRenderableWidget(helmetXPositionInput);
    this.addRenderableWidget(helmetYPositionInput);
    this.addRenderableWidget(helmetToggle);
    this.addRenderableWidget(chestplateXPositionInput);
    this.addRenderableWidget(chestplateYPositionInput);
    this.addRenderableWidget(chestplateToggle);
    this.addRenderableWidget(leggingsXPositionInput);
    this.addRenderableWidget(leggingsYPositionInput);
    this.addRenderableWidget(leggingsToggle);
    this.addRenderableWidget(bootsXPositionInput);
    this.addRenderableWidget(bootsYPositionInput);
    this.addRenderableWidget(bootsToggle);
    this.addRenderableWidget(saveAndQuitButton);
  }

  @Override
  public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
    int guiScale;
    int windowWidth = Minecraft.getInstance().getWindow().getWidth();
    int windowHeight = Minecraft.getInstance().getWindow().getHeight();

    if(Minecraft.getInstance().options.guiScale().get() != 0){
      guiScale = Minecraft.getInstance().options.guiScale().get();
    }
    else {
      guiScale = 4;
    }

    int textBoxWidth = windowWidth / (8 * guiScale);

    super.extractRenderState(graphics, mouseX, mouseY, a);
    int textBoxOffset = this.font.width(Component.translatable("config.armourhud.screen.label.chestplateposition")) + 15;

    graphics.textRenderer().accept(10,10, Component.translatable("config.armourhud.screen.title"));
    graphics.textRenderer().accept(10,40, Component.translatable("config.armourhud.screen.label.helmetposition"));
    graphics.textRenderer().accept(10,60, Component.translatable("config.armourhud.screen.label.chestplateposition"));
    graphics.textRenderer().accept(10,80, Component.translatable("config.armourhud.screen.label.leggingsposition"));
    graphics.textRenderer().accept(10,100, Component.translatable("config.armourhud.screen.label.bootsposition"));

    graphics.textRenderer().accept(textBoxOffset + (textBoxWidth / 2) - (this.font.width(Component.translatable("config.armourhud.screen.label.X")) / 2),20, Component.translatable("config.armourhud.screen.label.X"));
    graphics.textRenderer().accept(textBoxOffset + textBoxWidth + 15 + (textBoxWidth / 2) - (this.font.width(Component.translatable("config.armourhud.screen.label.Y")) / 2),20, Component.translatable("config.armourhud.screen.label.Y"));
    graphics.textRenderer().accept(textBoxOffset + (2 * textBoxWidth) + 30,20, Component.translatable("config.armourhud.screen.label.enabled"));
  }

  @Override
  public void onClose() {
    Minecraft.getInstance().setScreen(parent);
  }
}
