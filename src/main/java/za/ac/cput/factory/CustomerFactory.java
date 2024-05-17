package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.util.Helper;

public class CustomerFactory {

    public static Customer createCustomer(String customerId, String email, String password, String registrationDate, String role) {
        if (Helper.isNullOrEmpty(customerId) || Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(registrationDate) ||
                Helper.isNullOrEmpty(role)) {
            throw new IllegalArgumentException("All fields are required and cannot be null or empty.");
        }

        if (!Helper.testEmail(email)) {
            throw new IllegalArgumentException("Invalid email.");
        }

        return new Customer.Builder()
                .setCustomerId(customerId)
                .setEmail(email)
                .setPassword(password)
                .setRegistrationDate(registrationDate)
                .setRole(role)
                .build();
    }

    public static Customer createCustomer(String email, String password, String registrationDate, String role) {
        if (Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password) ||
                Helper.isNullOrEmpty(registrationDate) || Helper.isNullOrEmpty(role)) {
            throw new IllegalArgumentException("All fields are required and cannot be null or empty.");
        }

        if (!Helper.testEmail(email)) {
            throw new IllegalArgumentException("Invalid email.");
        }

        String customerId = Helper.generateId();
        return new Customer.Builder()
                .setCustomerId(customerId)
                .setEmail(email)
                .setPassword(password)
                .setRegistrationDate(registrationDate)
                .setRole(role)
                .build();
    }
}
