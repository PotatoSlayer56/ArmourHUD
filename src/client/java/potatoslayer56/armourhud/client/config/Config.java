package potatoslayer56.armourhud.client.config;

public class Config {
  public static ArmourPieceConfig helmetConfig;
  public static ArmourPieceConfig chestplateConfig;
  public static ArmourPieceConfig leggingsConfig;
  public static ArmourPieceConfig bootsConfig;

  public static void initialise(){
    helmetConfig = new ArmourPieceConfig(0,0,true);
    chestplateConfig = new ArmourPieceConfig(0,20,true);
    leggingsConfig = new ArmourPieceConfig(0,40,true);
    bootsConfig = new ArmourPieceConfig(0,60,true);
  }
}
