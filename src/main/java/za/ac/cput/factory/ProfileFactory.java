package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Profile;
import za.ac.cput.util.Helper;

public class ProfileFactory {

    public static Profile createProfile(String profileId, String firstName, String lastName, String phoneNumber, String emailAddress, String address, String role) {
        if (Helper.isNullOrEmpty(profileId) || Helper.isNullOrEmpty(firstName) ||
                Helper.isNullOrEmpty(lastName) || Helper.isNullOrEmpty(phoneNumber) ||
                Helper.isNullOrEmpty(emailAddress) || Helper.isNullOrEmpty(address) ||
                Helper.isNullOrEmpty(role)) {
            throw new IllegalArgumentException("All fields are required and cannot be null or empty.");
        }

        if (!Helper.testValidContact(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number.");
        }

        return new Profile.Builder()
                .setProfileId(profileId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(emailAddress)
                .setAddress(address)
                .setRole(role)
                .build();
    }

    public static Profile createProfile(String firstName, String lastName, String phoneNumber, String emailAddress, String address, String role) {
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(emailAddress) ||
                Helper.isNullOrEmpty(address) || Helper.isNullOrEmpty(role)) {
            throw new IllegalArgumentException("All fields are required and cannot be null or empty.");
        }

        if (!Helper.testValidContact(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number.");
        }

        String profileId = Helper.generateId();
        return new Profile.Builder()
                .setProfileId(profileId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmailAddress(emailAddress)
                .setAddress(address)
                .setRole(role)
                .build();
    }
}
