package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Admin;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void createAdmin() {
            String adminID = "A1818";
            String jobDescription = "Front Admin";

            Admin admin = AdminFactory.buildAdmin(adminID, jobDescription);

            assertNotNull(admin.getAdminID());
            assertEquals(adminID, admin.getAdminID());
            assertEquals(jobDescription, admin.getJob_description());
            System.out.println("Admin"+admin);
        }
    }
