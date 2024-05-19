package za.ac.cput.service;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class EmployeeServiceTest {
    @Autowired ///DONT FORGET THIS!!!NB!!!
    private EmployeeService employeeService;
    private static Employee employee1;
    private static Employee employee2;

    @Test
    @Order(1)
    void a_setup() {
        employee1 = EmployeeFactory.buildEmployee("220328626", "Reagan", "Cloete");
        assertNotNull(employee1);
        System.out.println(employee1);
        employee2 = EmployeeFactory.buildEmployee("220328627", "Reegz", "Cloetz");
        assertNotNull(employee2);
        System.out.println(employee2);

    }
    @Test
    @Order(2)
    void b_create() {
        Employee created1 = employeeService.create(employee1);
        assertNotNull(created1);
        System.out.println(created1);
        Employee created2 = employeeService.create(employee2);
        assertNotNull(created2);
        System.out.println(created2);
    }

    @Test
    @Order(3)
    void c_read() {
        Employee read = employeeService.read(employee2.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(4)
    void d_update() {
        Employee newEmployee = new Employee.Builder().copy(employee2).setFirstName("Reagz James").build();
        Employee updated = employeeService.update(newEmployee);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Order(5)
    void f_delete() {
        employeeService.delete(employee1);
        assertNull(employeeService.read(employee1.getEmployeeNumber()));
        System.out.println("Employee deleted: " + employee1);

        employeeService.delete(employee2);
        assertNull(employeeService.read(employee2.getEmployeeNumber()));
        System.out.println("Employee deleted: " + employee2);
    }

    @Test
    @Order(6)
    void e_getall() {System.out.println(employeeService.getall());}

}