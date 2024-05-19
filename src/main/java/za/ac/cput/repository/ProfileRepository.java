package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, String> {
}
