package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, String>{
    // public List<Employee> findAllByEmployeeNumberOrderByEmployeeNumber(String id);
    Employee findEmployeeByFirstName(String firstName);
    void deleteEmployeeByFirstName(String firstName);
    void deleteEmployeesByLastName(String lastName);
}
