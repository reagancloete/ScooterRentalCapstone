package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Scooter;
import za.ac.cput.domain.ScooterType;
import za.ac.cput.factory.ScooterFactory;
import za.ac.cput.factory.ScooterTypeFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class ScooterServiceTest {

    @Autowired
    ScooterService scooterService;

    ScooterType scooterType = ScooterTypeFactory.buildScooterType("Electric", 50, 100.00);
    Scooter scooter = ScooterFactory.buildScooter("XYZ 123 456", "Yamaha", "Red", "2021", "NMAX 155", scooterType);

    @Test
    void a_create() {
        // Act
        Scooter scooter1 = scooterService.create(scooter);

        // Assert
        assertNotNull(scooter1);
        assertEquals("XYZ 123 456", scooter1.getNumberPlate());
    }

    @Test
    void b_read() {
        // Act
        Scooter scooter1 = scooterService.read(scooter.getNumberPlate());

        // Assert
        assertNotNull(scooter1);
        assertEquals("Yamaha", scooter1.getScooterMake());
    }

    @Test
    void update() {
        // no test implementation for update
    }

    @Test
    void d_delete() {
        scooterService.delete(scooter.getNumberPlate());

        List<Scooter> scooters;
        scooters = scooterService.getAll();

        assertFalse(scooters.contains(scooter));
    }

    @Test
    void c_getAll() {
        List<Scooter> scooters;
        scooters = scooterService.getAll();

        assertNotNull(scooters);
        assertTrue(scooters.contains(scooter));
    }
}
