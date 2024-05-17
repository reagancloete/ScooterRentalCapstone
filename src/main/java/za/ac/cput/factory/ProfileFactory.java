package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Profile;
import za.ac.cput.util.Helper;

public class ProfileFactory {

    public static Profile createProfile(String profileId, String name, String phoneNumber, String licenseNumber, String dateOfBirth, String address, Customer customer) {
        if (Helper.isNullOrEmpty(profileId) || Helper.isNullOrEmpty(name) ||
                Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(licenseNumber) ||
                Helper.isNullOrEmpty(dateOfBirth) || Helper.isNullOrEmpty(address) || customer == null) {
            throw new IllegalArgumentException("All fields are required and cannot be null or empty.");
        }

        if (!Helper.testValidContact(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number.");
        }

        return new Profile.Builder()
                .setProfileId(profileId)
                .setName(name)
                .setPhoneNumber(phoneNumber)
                .setLicenseNumber(licenseNumber)
                .setDateOfBirth(dateOfBirth)
                .setAddress(address)
                .setCustomer(customer)
                .build();
    }

    public static Profile createProfile(String name, String phoneNumber, String licenseNumber, String dateOfBirth, String address, Customer customer) {
        if (Helper.isNullOrEmpty(name) || Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(licenseNumber) || Helper.isNullOrEmpty(dateOfBirth) ||
                Helper.isNullOrEmpty(address) || customer == null) {
            throw new IllegalArgumentException("All fields are required and cannot be null or empty.");
        }

        if (!Helper.testValidContact(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number.");
        }

        String profileId = Helper.generateId();
        return new Profile.Builder()
                .setProfileId(profileId)
                .setName(name)
                .setPhoneNumber(phoneNumber)
                .setLicenseNumber(licenseNumber)
                .setDateOfBirth(dateOfBirth)
                .setAddress(address)
                .setCustomer(customer)
                .build();
    }
}
