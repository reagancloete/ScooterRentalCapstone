package za.ac.cput.factory;


import za.ac.cput.domain.Booking;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

public class BookingFactory {

    public static Booking buildBooking(Long bookingId, LocalDateTime bookingDate, Long customerId, Long scooterId) {
        if (!Helper.testValidContact(String.valueOf(customerId)) || !Helper.testValidContact(String.valueOf(scooterId))) {
            throw new IllegalArgumentException("Customer ID and scooter ID must be valid contact numbers");
        }
        return new Booking.Builder()
                .setBookingId(bookingId)
                .setBookingDate(bookingDate)
                .setCustomerId(customerId)
                .setScooterId(scooterId)
                .build();
    }
}
