package za.ac.cput.service;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.EmployeeFactory;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactServiceTest {
    @Autowired
    private ContactService contactService;
    private static Contact contact1;
    private static Contact contact2;
    @Test
    @Order(1)
    void a_setup() {
        contact1 = ContactFactory.buildContact("210328626@mycput.ac.za", "0765427694", "0217827469");
        assertNotNull(contact1);
        System.out.println(contact1);
        contact2 = ContactFactory.buildContact("220328627@mycput.ac.za", "0765427695", "0217827468");
        assertNotNull(contact2);
        System.out.println(contact2);

    }

//    @Test
//    @Order(2)
//    void b_create() {
//        for(int i =0; i<2;i++){
//            Contact con = ContactFactory.buildContact("Email" + i + "@gmail.com");
//            assertEquals(con, contactService.create(con));
//        }
//    }

    @Test
    @Order(2)
    void b_create() {
        Contact created1 = contactService.create(contact1);
        assertNotNull(created1);
        System.out.println(created1);

        Contact created2 = contactService.create(contact2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    //    @Test
//    @Order(3)
//    void c_read() {
//        Contact readContact = contactService.read(contact1.getEmail());
//        assertNotNull(readContact);
//        assertEquals(contact1, readContact);
//        System.out.println(readContact);
//    }
    @Test
    @Order(3)
    void c_read() {
        Contact readContact1 = contactService.read(contact1.getEmail());
        assertNotNull(readContact1);
        assertEquals(contact1, readContact1);
        System.out.println(readContact1);

        Contact readContact2 = contactService.read(contact2.getEmail());
        assertNotNull(readContact2);
        assertEquals(contact2, readContact2);
        System.out.println(readContact2);
    }

    @Test
    @Order(4)
    void d_update() {
        Contact updatedContact = new Contact.Builder()
                .copy(contact2)
                .setMobile("0760000000")
                .build();
        Contact updated = contactService.update(updatedContact);
        assertNotNull(updated);
        assertEquals("0760000000", updated.getMobile());
        System.out.println(updated);
    }
//    @Test
//    @Order(5)
//    void e_delete() {
//        contactService.delete(contact1);
//        assertThrows(NoSuchElementException.class, () -> contactService.read(contact1.getEmail()));
//        System.out.println("Contact deleted: " + contact1);
//
//        contactService.delete(contact2);
//        assertThrows(NoSuchElementException.class, () -> contactService.read(contact2.getEmail()));
//        System.out.println("Contact deleted: " + contact2);
//    }

    @Test
    @Order(6)
    void f_getall() {
        List<Contact> contacts = contactService.getall();
        assertNotNull(contacts);
        assertFalse(contacts.isEmpty());
        System.out.println(contacts);
    }

}