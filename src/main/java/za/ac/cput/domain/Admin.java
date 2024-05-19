/*
Admin.java
This is the Admin class
author :Lelam Valisi
Date :  17 May 2024
 */
package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;


import java.util.Objects;

@Entity
public class Admin {
    @Id
    private String adminID;
    private String job_description;

    @OneToOne
    @JoinColumn(name = "bookingID")
    private Booking booking;

    public Admin() {}

    public Admin(Builder builder) {
        this.adminID = builder.adminID;
        this.job_description = builder.job_description;
        this.booking = builder.booking;
    }

    public String getAdminID() {
        return adminID;
    }

    public String getJob_description() {
        return job_description;
    }

    public Booking getBooking() {
        return booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminID, admin.adminID) &&
                Objects.equals(job_description, admin.job_description) &&
                Objects.equals(booking, admin.booking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminID, job_description, booking);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID='" + adminID + '\'' +
                ", job_description='" + job_description + '\'' +
                ", booking=" + booking +
                '}';
    }

    public static class Builder {
        private String adminID;
        private String job_description;
        private Booking booking;

        public Builder setAdminID(String adminID) {
            this.adminID = adminID;
            return this;
        }

        public Builder setJob_description(String job_description) {
            this.job_description = job_description;
            return this;
        }

        public Builder setBooking(Booking booking) {
            this.booking = booking;
            return this;
        }

        public Builder copy(Admin admin) {
            this.adminID = admin.adminID;
            this.job_description = admin.job_description;
            this.booking = admin.booking;
            return this;
        }

        public Admin build() {
            return new Admin(this);
        }
    }
}
