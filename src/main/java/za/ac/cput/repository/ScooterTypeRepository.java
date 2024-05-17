package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.ScooterType;

public interface ScooterTypeRepository extends JpaRepository<ScooterType, Long> {

}
