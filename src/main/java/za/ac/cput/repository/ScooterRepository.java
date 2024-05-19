package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Scooter;

public interface ScooterRepository extends JpaRepository<Scooter, String> {

}
