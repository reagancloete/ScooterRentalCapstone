package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Booking;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingFactoryTest {


    @Test
    void createBookingInvalidCustomerId() {
        Long bookingId = 1L;
        LocalDateTime bookingDate = LocalDateTime.now();
        Long customerId = 123456789012345L; // Invalid contact number
        Long scooterId = 2001L;

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.buildBooking(bookingId, bookingDate, customerId, scooterId);
        });

        String expectedMessage = "Customer ID and scooter ID must be valid contact numbers";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void createBookingInvalidScooterId() {
        Long bookingId = 1L;
        LocalDateTime bookingDate = LocalDateTime.now();
        Long customerId = 1001L;
        Long scooterId = 123456789012345L; // Invalid contact number

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            BookingFactory.buildBooking(bookingId, bookingDate, customerId, scooterId);
        });

        String expectedMessage = "Customer ID and scooter ID must be valid contact numbers";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}