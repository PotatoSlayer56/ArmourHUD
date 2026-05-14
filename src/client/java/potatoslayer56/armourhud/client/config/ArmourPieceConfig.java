package potatoslayer56.armourhud.client.config;

public class ArmourPieceConfig {
  private int xPos;
  private int yPos;

  private boolean enabled;

  public ArmourPieceConfig(int x, int y, boolean b) {
    this.xPos = x;
    this.yPos = y;
    this.enabled = b;
  }

  public int getXPos(){
    return this.xPos;
  }
  public int getYPos(){
    return this.yPos;
  }
  public boolean isEnabled(){
    return this.enabled;
  }

  public void setXPos(int pos){
    this.xPos = pos;
  }
  public void setYPos(int pos){
    this.yPos = pos;
  }
  public void setEnabled(boolean bool){
    this.enabled = bool;
  }
}
