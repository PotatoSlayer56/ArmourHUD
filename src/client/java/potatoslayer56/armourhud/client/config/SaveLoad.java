package potatoslayer56.armourhud.client.config;

import com.google.gson.Gson;
import potatoslayer56.armourhud.ArmourHUD;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveLoad {
  public static String configPath = "config/armourhud.config";

  public static void saveConfig() {
    Gson gson = new Gson();
    try{
      FileWriter fileWriter = new FileWriter(configPath);
      fileWriter.write(gson.toJson(Config.helmetConfig));fileWriter.write("\n");
      fileWriter.write(gson.toJson(Config.chestplateConfig));fileWriter.write("\n");
      fileWriter.write(gson.toJson(Config.leggingsConfig));fileWriter.write("\n");
      fileWriter.write(gson.toJson(Config.bootsConfig));fileWriter.write("\n");
      fileWriter.close();
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void loadConfig() {
    try {
      File configFile = new File(configPath);
      BufferedReader bufferedReader = new BufferedReader(new FileReader(configFile));
      List<String> data = new ArrayList<String>();
      String st;

      while ((st = bufferedReader.readLine()) != null){
        data.add(st);
      }

      Gson gson = new Gson();

      Config.helmetConfig = gson.fromJson(data.get(0), ArmourPieceConfig.class);
      Config.chestplateConfig = gson.fromJson(data.get(1), ArmourPieceConfig.class);
      Config.leggingsConfig = gson.fromJson(data.get(2), ArmourPieceConfig.class);
      Config.bootsConfig = gson.fromJson(data.get(3), ArmourPieceConfig.class);
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static void createConfig() {
    try {
      File configFile = new File(configPath);
      if (configFile.createNewFile()) {
        ArmourHUD.LOGGER.info("Config created");
        saveConfig();
      }
      else {
        ArmourHUD.LOGGER.info("Config exists");
      }
    }
    catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
