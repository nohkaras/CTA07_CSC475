package com.sara.cta07_unitconverterapp;

/* Used for unit testing - Utils class
kmToM() - Method to convert kilometers to meters
kmToCm() - Method to convert kilometers to centimeters
kmToMile() - Method to convert kilometers to miles
kmToYard() - Method to convert kilometers to yards
kmToFoot() - Method to convert kilometers to feet
kmToInch() - Method to convert kilometers to inches
 */
public class ConverterUnit {
    public static double kmToM(double km) {
        return km * 1000;
    }
    //-------------------
    public static double kmToCm(double km) {
        return km * 100000;
    }
    //-------------------
    public static double kmToMile(double km) {
        return km / 1.609;
    }
    //-------------------
    public static double kmToYard(double km) {
        return km * 1094;
    }
    //--------------------
    public static double kmToFoot(double km) {
        return km * 3281;
    }
    //-------------------
    public static double kmToInch(double km) {
        return km * 39370;
    }
}
