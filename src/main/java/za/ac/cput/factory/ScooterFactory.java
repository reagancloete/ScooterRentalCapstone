package za.ac.cput.factory;

import za.ac.cput.domain.Scooter;
import za.ac.cput.domain.ScooterType;
import za.ac.cput.util.Helper;

public class ScooterFactory {

    public static Scooter createScooter(String numberPlate, String scooterMake, String scooterColor, String year, String scooterName, ScooterType scooterType) {
        if (Helper.isNullOrEmpty(numberPlate) || Helper.isNullOrEmpty(scooterMake) ||
                Helper.isNullOrEmpty(scooterColor) || Helper.isNullOrEmpty(year) ||
                Helper.isNullOrEmpty(scooterName) || scooterType == null) {
            throw new IllegalArgumentException("All fields are required and cannot be null or empty.");
        }

        return new Scooter.Builder()
                .setNumberPlate(numberPlate)
                .setScooterMake(scooterMake)
                .setScooterColor(scooterColor)
                .setYear(year)
                .setScooterName(scooterName)
                .setScooterType(scooterType)
                .build();
    }
}
