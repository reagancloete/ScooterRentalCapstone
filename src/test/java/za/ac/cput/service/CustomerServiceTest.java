package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    private static Customer customer1;
    private static Customer customer2;

    @Test
    @Order(1)
    void a_setup() {
        customer1 = CustomerFactory.createCustomer("1", "test1@example.com", "password1", "2024-05-19", "user");
        assertNotNull(customer1);
        System.out.println(customer1);

        customer2 = CustomerFactory.createCustomer("2", "test2@example.com", "password2", "2024-05-20", "admin");
        assertNotNull(customer2);
        System.out.println(customer2);
    }

    @Test
    @Order(2)
    void b_create() {
        Customer created1 = customerService.create(customer1);
        assertNotNull(created1);
        System.out.println(created1);

        Customer created2 = customerService.create(customer2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void c_read() {
        Customer read1 = customerService.read(customer1.getCustomerId());
        assertNotNull(read1);
        assertEquals(customer1, read1);
        System.out.println(read1);

        Customer read2 = customerService.read(customer2.getCustomerId());
        assertNotNull(read2);
        assertEquals(customer2, read2);
        System.out.println(read2);
    }

    @Test
    @Order(4)
    void d_update() {
        Customer updated1 = new Customer.Builder()
                .copy(customer1)
                .setEmail("updated1@example.com")
                .build();
        Customer updatedCustomer1 = customerService.update(updated1);
        assertNotNull(updatedCustomer1);
        assertEquals("updated1@example.com", updatedCustomer1.getEmail());
        System.out.println(updatedCustomer1);

        Customer updated2 = new Customer.Builder()
                .copy(customer2)
                .setEmail("updated2@example.com")
                .build();
        Customer updatedCustomer2 = customerService.update(updated2);
        assertNotNull(updatedCustomer2);
        assertEquals("updated2@example.com", updatedCustomer2.getEmail());
        System.out.println(updatedCustomer2);
    }

    @Test
    @Order(5)
    void e_delete() {
        customerService.delete(customer1);
        assertThrows(NoSuchElementException.class, () -> customerService.read(customer1.getCustomerId()));
        System.out.println("Customer deleted: " + customer1);

        customerService.delete(customer2);
        assertThrows(NoSuchElementException.class, () -> customerService.read(customer2.getCustomerId()));
        System.out.println("Customer deleted: " + customer2);
    }

    @Test
    @Order(6)
    void f_getall() {
        List<Customer> customers = customerService.getall();
        assertNotNull(customers);
        assertFalse(customers.isEmpty());
        System.out.println(customers);
    }
}
