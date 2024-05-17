package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Scooter;
import za.ac.cput.domain.ScooterType;

import static org.junit.jupiter.api.Assertions.*;

class ScooterFactoryTest {

    @Test
    void createScooter_ValidInput_Success() {
        // Arrange
        String numberPlate = "CA123456";
        String scooterMake = "Yamaha";
        String scooterColor = "Blue";
        String year = "2022";
        String scooterName = "ModelX";
        ScooterType scooterType = new ScooterType.Builder()
                .setScooterDescription("Electric Scooter")
                .setCapacity(2)
                .setRentalPrice(299.99)
                .build();

        // Act
        Scooter scooter = ScooterFactory.createScooter(numberPlate, scooterMake, scooterColor, year, scooterName, scooterType);

        // Assert
        assertNotNull(scooter);
        assertEquals(numberPlate, scooter.getNumberPlate());
        assertEquals(scooterMake, scooter.getScooterMake());
        assertEquals(scooterColor, scooter.getScooterColor());
        assertEquals(year, scooter.getYear());
        assertEquals(scooterName, scooter.getScooterName());
        assertEquals(scooterType, scooter.getScooterType());
    }

    @Test
    void createScooter_NullNumberPlate_ExceptionThrown() {
        // Arrange
        String numberPlate = null;
        String scooterMake = "Yamaha";
        String scooterColor = "Blue";
        String year = "2022";
        String scooterName = "ModelX";
        ScooterType scooterType = new ScooterType.Builder()
                .setScooterDescription("Electric Scooter")
                .setCapacity(2)
                .setRentalPrice(299.99)
                .build();

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> ScooterFactory.createScooter(numberPlate, scooterMake, scooterColor, year, scooterName, scooterType));
    }

    // Add more test cases for other invalid inputs as needed
}
