package net.armourhud.config;

import org.jetbrains.annotations.ApiStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static net.armourhud.ArmourHUD.LOGGER;

public class config {

    public static boolean hudEnabled;
    public static int xHelmetLocation;
    public static int yHelmetLocation;
    public static int xChestplateLocation;
    public static int yChestplateLocation;
    public static int xLeggingsLocation;
    public static int yLeggingsLocation;
    public static int xBootsLocation;
    public static int yBootsLocation;

    public static String configPath = "config/armourhud-config.properties";
    public static void createConfig() {
        try {
            File configFile = new File(configPath);
            if(configFile.createNewFile()) {
                LOGGER.info("Config created");
            }
            else {
                LOGGER.info("Config exists");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeConfig() {
        if (xHelmetLocation == 0) {
            xHelmetLocation = 50;
        }
        if (yHelmetLocation == 0) {
            yHelmetLocation = 50;
        }
        if (xChestplateLocation == 0) {
            xChestplateLocation = 50;
        }
        if (yChestplateLocation == 0) {
            yChestplateLocation = 70;
        }
        if (xLeggingsLocation == 0) {
            xLeggingsLocation = 50;
        }
        if (yLeggingsLocation == 0) {
            yLeggingsLocation = 90;
        }
        if (xBootsLocation == 0) {
            xBootsLocation = 50;
        }
        if (yBootsLocation == 0) {
            yBootsLocation = 110;
        }
        try {
            FileWriter fileWriter = new FileWriter(configPath);
            fileWriter.write(String.valueOf(xHelmetLocation));fileWriter.write("\n");
            fileWriter.write(String.valueOf(yHelmetLocation));fileWriter.write("\n");
            fileWriter.write(String.valueOf(xChestplateLocation));fileWriter.write("\n");
            fileWriter.write(String.valueOf(yChestplateLocation));fileWriter.write("\n");
            fileWriter.write(String.valueOf(xLeggingsLocation));fileWriter.write("\n");
            fileWriter.write(String.valueOf(yLeggingsLocation));fileWriter.write("\n");
            fileWriter.write(String.valueOf(xBootsLocation));fileWriter.write("\n");
            fileWriter.write(String.valueOf(yBootsLocation));fileWriter.write("\n");
            fileWriter.write(String.valueOf(hudEnabled));fileWriter.write("\n");
            fileWriter.close();
            LOGGER.info("Config written");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readConfig() {
        try {
            File configFile = new File(configPath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(configFile));
            List<String> data = new ArrayList<String>();
            String st;
            try {
                while ((st = bufferedReader.readLine()) != null) {
                    data.add(st);
                    LOGGER.warn(st);
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            try {
                LOGGER.info(data.toString());
                xHelmetLocation = Integer.valueOf(data.get(0));
                yHelmetLocation = Integer.valueOf(data.get(1));
                xChestplateLocation = Integer.valueOf(data.get(2));
                yChestplateLocation = Integer.valueOf(data.get(3));
                xLeggingsLocation = Integer.valueOf(data.get(4));
                yLeggingsLocation = Integer.valueOf(data.get(5));
                xBootsLocation = Integer.valueOf(data.get(6));
                yBootsLocation = Integer.valueOf(data.get(7));
                hudEnabled = Boolean.valueOf(data.get(8));
            }
            catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}