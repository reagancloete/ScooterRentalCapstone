package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ScooterType;
import za.ac.cput.factory.ScooterTypeFactory;
import za.ac.cput.service.ScooterTypeServiceTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ScooterTypeServiceTest {

    @Autowired
    private ScooterTypeService scooterTypeService;

    private static final ScooterType scooterType = ScooterTypeFactory.buildScooterType(
            "Electric Scooter", 50, 100.00);

    @Test
    void a_create() {
        // Act
        ScooterType created = scooterTypeService.create(scooterType);

        // Assert
        assertNotNull(created);
        assertEquals(scooterType.getScooterDescription(), created.getScooterDescription());
    }

    @Test
    void b_read() {
        // Act
        ScooterType read = scooterTypeService.read(scooterType.getId());

        // Assert
        assertNotNull(read);
        assertEquals(scooterType.getScooterDescription(), read.getScooterDescription());
    }

    @Test
    void c_update() {
        // Arrange
        ScooterType updatedScooterType = new ScooterType.Builder()
                .copy(scooterType)
                .setRentalPrice(120.00)
                .build();

        // Act
        ScooterType updated = scooterTypeService.update(updatedScooterType);

        // Assert
        assertNotNull(updated);
        assertEquals(120.00, updated.getRentalPrice());
    }

    @Test
    void d_delete() {
        // Act
        scooterTypeService.delete(scooterType.getId());

        // Assert
        ScooterType deleted = scooterTypeService.read(scooterType.getId());
        assertNull(deleted);
    }

    @Test
    void e_getAll() {
        // Act
        List<ScooterType> scooterTypes = scooterTypeService.getAll();

        // Assert
        assertNotNull(scooterTypes);
        assertTrue(scooterTypes.size() > 0);
    }
}
