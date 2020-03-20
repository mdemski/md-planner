package pl.okpol.mdplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.okpol.mdplanner.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    long countByEmail(String email);
}
