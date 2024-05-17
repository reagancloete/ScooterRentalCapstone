package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ScooterType;

import static org.junit.jupiter.api.Assertions.*;

class ScooterTypeFactoryTest {

    @Test
    void createScooterType_ValidInput_Success() {
        // Arrange
        String description = "Electric Scooter";
        int capacity = 2;
        double rentalPrice = 299.99;

        // Act
        ScooterType scooterType = ScooterTypeFactory.createScooterType(description, capacity, rentalPrice);

        // Assert
        assertNotNull(scooterType);
        assertEquals(description, scooterType.getScooterDescription());
        assertEquals(capacity, scooterType.getCapacity());
        assertEquals(rentalPrice, scooterType.getRentalPrice());
    }

    @Test
    void createScooterType_NullDescription_ExceptionThrown() {
        // Arrange
        String description = null;
        int capacity = 2;
        double rentalPrice = 299.99;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> ScooterTypeFactory.createScooterType(description, capacity, rentalPrice));
    }

    @Test
    void createScooterType_NegativeCapacity_ExceptionThrown() {
        // Arrange
        String description = "Electric Scooter";
        int capacity = -2;
        double rentalPrice = 299.99;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> ScooterTypeFactory.createScooterType(description, capacity, rentalPrice));
    }

    @Test
    void createScooterType_ZeroRentalPrice_ExceptionThrown() {
        // Arrange
        String description = "Electric Scooter";
        int capacity = 2;
        double rentalPrice = 0;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> ScooterTypeFactory.createScooterType(description, capacity, rentalPrice));
    }
}
