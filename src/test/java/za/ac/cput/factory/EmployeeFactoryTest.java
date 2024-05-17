package za.ac.cput.factory;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
//Reagan
class EmployeeFactoryTest {
    @Test
    void testBuildEmployee(){
        Employee e = EmployeeFactory.buildEmployee("220328625", "Reagan", "Cloete");
        assertNotNull(e);
        System.out.println(e.toString());
    }

    @Test
    void testBuildEmployeeWithFail(){
        Employee e = EmployeeFactory.buildEmployee("", "Reagan", "Cloete");
        assertNull(e);
        System.out.println(e);
    }

}