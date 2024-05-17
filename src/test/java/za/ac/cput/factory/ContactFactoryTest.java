package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Contact;
//Reagan
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ContactFactoryTest
{
    @Test
    void testBuildContactWithAllFields() {
        String email = "reagan@example.com";
        String mobile = "0765427694";
        String workTel = "0217827469";

        Contact contact = ContactFactory.buildContact(email, mobile, workTel);
        assertNotNull(contact);
        System.out.println(contact.toString());
        assertEquals(email, contact.getEmail());
        assertEquals(mobile, contact.getMobile());
        assertEquals(workTel, contact.getWorkTel());
    }

    @Test
    void testBuildContactWithOnlyEmail() {
        String email = "test@gmail.com";

        Contact contact = ContactFactory.buildContact(email);
        assertNotNull(contact);
        System.out.println(contact.toString());
        assertEquals(email, contact.getEmail());
        assertNull(contact.getMobile());
        assertNull(contact.getWorkTel());
    }

    @Test
    void testBuildContactWithInvalidEmail() {
        String email = "invalid-email";
        String mobile = "0765427694";
        String workTel = "0217827469";

        Contact contact = ContactFactory.buildContact(email, mobile, workTel);
        assertNull(contact);
        System.out.println("Contact create failed due to invalid email.");
    }

    @Test
    void testBuildContactWithInvalidMobile() {
        String email = "reagan@gmail";
        String mobile = "0";
        String workTel = "0217827469";
        System.out.println("Contact create failed due to invalid mobile number for: " + email + "/" + workTel);
        Contact contact = ContactFactory.buildContact(email, mobile, workTel);
        //assertNull(contact);
    }

    @Test
    void testBuildContactWithInvalidWorkTel() {
        String email = "test@example.com";
        String mobile = "0765427694";
        String workTel = "invalid-worktel";

        Contact contact = ContactFactory.buildContact(email, mobile, workTel);
        assertNull(contact);
        System.out.println("Contact create failed due to invalid work telephone ");
    }

    @Test
    void testBuildContactWithNullValues() {
        Contact contact = ContactFactory.buildContact(null, null, null);
        assertNull(contact);
        System.out.println("Contact create failed due to null values: " + contact);
    }
}