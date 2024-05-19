package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Profile;
import za.ac.cput.factory.ProfileFactory;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProfileServiceTest {

    @Autowired
    private ProfileService profileService;

    private static Profile profile1;
    private static Profile profile2;

    @Test
    @Order(1)
    void a_setup() {
        profile1 = ProfileFactory.createProfile("1", "John", "Doe", "123456789", "john@example.com", "123 Main St", "user");
        assertNotNull(profile1);
        System.out.println(profile1);

        profile2 = ProfileFactory.createProfile("2", "Jane", "Doe", "987654321", "jane@example.com", "456 Elm St", "admin");
        assertNotNull(profile2);
        System.out.println(profile2);
    }

    @Test
    @Order(2)
    void b_create() {
        Profile created1 = profileService.create(profile1);
        assertNotNull(created1);
        System.out.println(created1);

        Profile created2 = profileService.create(profile2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void c_read() {
        Profile read1 = profileService.read(profile1.getProfileId());
        assertNotNull(read1);
        assertEquals(profile1, read1);
        System.out.println(read1);

        Profile read2 = profileService.read(profile2.getProfileId());
        assertNotNull(read2);
        assertEquals(profile2, read2);
        System.out.println(read2);
    }

    @Test
    @Order(4)
    void d_update() {
        Profile updated1 = new Profile(profile1.getProfileId(), profile1.getFirstName(), profile1.getLastName(),
                profile1.getPhoneNumber(), "updatedjohn@example.com", profile1.getAddress(), profile1.getRole());
        Profile updatedProfile1 = profileService.update(updated1);
        assertNotNull(updatedProfile1);
        assertEquals("updatedjohn@example.com", updatedProfile1.getEmailAddress());
        System.out.println(updatedProfile1);

        Profile updated2 = new Profile(profile2.getProfileId(), profile2.getFirstName(), profile2.getLastName(),
                profile2.getPhoneNumber(), "updatedjane@example.com", profile2.getAddress(), profile2.getRole());
        Profile updatedProfile2 = profileService.update(updated2);
        assertNotNull(updatedProfile2);
        assertEquals("updatedjane@example.com", updatedProfile2.getEmailAddress());
        System.out.println(updatedProfile2);
    }

    @Test
    @Order(5)
    void e_delete() {
        profileService.delete(profile1);
        assertThrows(NoSuchElementException.class, () -> profileService.read(profile1.getProfileId()));
        System.out.println("Profile deleted: " + profile1);

        profileService.delete(profile2);
        assertThrows(NoSuchElementException.class, () -> profileService.read(profile2.getProfileId()));
        System.out.println("Profile deleted: " + profile2);
    }

    @Test
    @Order(6)
    void f_getall() {
        List<Profile> profiles = profileService.getall();
        assertNotNull(profiles);
        assertFalse(profiles.isEmpty());
        System.out.println(profiles);
    }
}
