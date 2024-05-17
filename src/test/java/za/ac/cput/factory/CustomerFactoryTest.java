package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    @Test
    void testCreateCustomerWithAllFields() {
        String customerId = "C123";
        String email = "aviwe@example.com";
        String password = "password";
        String registrationDate = "2023-01-01";
        String role = "ROLE_USER";

        Customer customer = CustomerFactory.createCustomer(customerId, email, password, registrationDate, role);
        assertNotNull(customer);
        System.out.println(customer.toString());
        assertEquals(customerId, customer.getCustomerId());
        assertEquals(email, customer.getEmail());
        assertEquals(password, customer.getPassword());
        assertEquals(registrationDate, customer.getRegistrationDate());
        assertEquals(role, customer.getRole());
    }

    @Test
    void testCreateCustomerWithGeneratedId() {
        String email = "aviwe@example.com";
        String password = "password";
        String registrationDate = "2023-01-01";
        String role = "ROLE_USER";

        Customer customer = CustomerFactory.createCustomer(email, password, registrationDate, role);
        assertNotNull(customer);
        System.out.println(customer.toString());
        assertNotNull(customer.getCustomerId());
        assertEquals(email, customer.getEmail());
        assertEquals(password, customer.getPassword());
        assertEquals(registrationDate, customer.getRegistrationDate());
        assertEquals(role, customer.getRole());
    }

    @Test
    void testCreateCustomerWithInvalidEmail() {
        String customerId = "C123";
        String email = "invalid-email";
        String password = "password";
        String registrationDate = "2023-01-01";
        String role = "ROLE_USER";

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CustomerFactory.createCustomer(customerId, email, password, registrationDate, role);
        });

        String expectedMessage = "Invalid email.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateCustomerWithNullValues() {
        String email = "aviwe@example.com";
        String password = "password";
        String registrationDate = "2023-01-01";
        String role = "ROLE_USER";

        Customer customer = CustomerFactory.createCustomer(email, password, registrationDate, role);
        assertNotNull(customer);
        System.out.println(customer.toString());
        assertNotNull(customer.getCustomerId());
        assertEquals(email, customer.getEmail());
        assertEquals(password, customer.getPassword());
        assertEquals(registrationDate, customer.getRegistrationDate());
        assertEquals(role, customer.getRole());
    }
}

