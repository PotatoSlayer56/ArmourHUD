package net.armourhud.config;

public class durabilityColourChanger {
    public static String getDurabilityColour(int maxDurability, int curDurability) {
        String fineColour = "f";
        String lowColour = "6";
        String veryLowColour = "4";
        String colour;
        if ((maxDurability/100) * 10 > curDurability) {
            colour = veryLowColour;
        }
        else if ((maxDurability/100) * 20 > curDurability) {
            colour = lowColour;
        }
        else {
            colour = fineColour;
        }
        return colour;
    }
}
