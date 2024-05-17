package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ProfileFactoryTest {

    @Test
    void testCreateProfileWithAllFields() {
        String profileId = "P123";
        String firstName = "Aviwe";
        String lastName = "Mbolekwa";
        String phoneNumber = "1234567890";
        String emailAddress = "aviwe.mbolekwa@example.com";
        String address = "123 Main St, City";
        String role = "ROLE_USER";

        Profile profile = ProfileFactory.createProfile(profileId, firstName, lastName, phoneNumber, emailAddress, address, role);
        assertNotNull(profile);
        System.out.println("Profile created with all fields: " + profile);
        assertEquals(profileId, profile.getProfileId());
        assertEquals(firstName, profile.getFirstName());
        assertEquals(lastName, profile.getLastName());
        assertEquals(phoneNumber, profile.getPhoneNumber());
        assertEquals(emailAddress, profile.getEmailAddress());
        assertEquals(address, profile.getAddress());
        assertEquals(role, profile.getRole());
    }

    @Test
    void testCreateProfileWithGeneratedId() {
        String firstName = "Aviwe";
        String lastName = "Mbolekwa";
        String phoneNumber = "1234567890";
        String emailAddress = "aviwe.mbolekwa@example.com";
        String address = "123 Main St, City";
        String role = "ROLE_USER";

        Profile profile = ProfileFactory.createProfile(firstName, lastName, phoneNumber, emailAddress, address, role);
        assertNotNull(profile);
        System.out.println("Profile created with generated ID: " + profile);
        assertNotNull(profile.getProfileId());
        assertEquals(firstName, profile.getFirstName());
        assertEquals(lastName, profile.getLastName());
        assertEquals(phoneNumber, profile.getPhoneNumber());
        assertEquals(emailAddress, profile.getEmailAddress());
        assertEquals(address, profile.getAddress());
        assertEquals(role, profile.getRole());
    }
}

