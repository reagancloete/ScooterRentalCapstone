package za.ac.cput.factory;

import za.ac.cput.domain.ScooterType;
import za.ac.cput.util.Helper;

public class ScooterTypeFactory {

    public static ScooterType createScooterType(String scooterDescription, int capacity, double rentalPrice) {
        if (Helper.isNullOrEmpty(scooterDescription) || capacity <= 0 || rentalPrice <= 0) {
            throw new IllegalArgumentException("Invalid input values.");
        }

        return new ScooterType.Builder()
                .setScooterDescription(scooterDescription)
                .setCapacity(capacity)
                .setRentalPrice(rentalPrice)
                .build();
    }
}
