package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

    List<Admin> findByAdminID(String adminID);

}
