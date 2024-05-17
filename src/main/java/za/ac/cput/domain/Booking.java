
package za.ac.cput.domain;

import jakarta.persistence.Entity;
/*
Admin.java
This is the Admin class
author :Lelam Valisi
Date :  17 May 2024
 */
import jakarta.persistence.Id;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Booking implements Serializable {
    @Id
    private Long bookingId;
    private LocalDateTime bookingDate;
    private Long customerId;
    private Long scooterId;

    public Booking() {}

    public Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.bookingDate = builder.bookingDate;
        this.customerId = builder.customerId;
        this.scooterId = builder.scooterId;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getScooterId() {
        return scooterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingId, booking.bookingId) &&
                Objects.equals(bookingDate, booking.bookingDate) &&
                Objects.equals(customerId, booking.customerId) &&
                Objects.equals(scooterId, booking.scooterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, bookingDate, customerId, scooterId);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", bookingDate=" + bookingDate +
                ", customerId=" + customerId +
                ", scooterId=" + scooterId +
                '}';
    }

    public static class Builder {
        private Long bookingId;
        private LocalDateTime bookingDate;
        private Long customerId;
        private Long scooterId;

        public Builder setBookingId(Long bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setBookingDate(LocalDateTime bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public Builder setCustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder setScooterId(Long scooterId) {
            this.scooterId = scooterId;
            return this;
        }

        public Builder copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.bookingDate = booking.bookingDate;
            this.customerId = booking.customerId;
            this.scooterId = booking.scooterId;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}
