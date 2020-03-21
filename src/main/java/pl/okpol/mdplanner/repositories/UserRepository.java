package pl.okpol.mdplanner.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.okpol.mdplanner.model.AbstractEntity;
import pl.okpol.mdplanner.model.User;

import java.util.Optional;

public interface UserRepository<T extends AbstractEntity, L extends Number> extends JpaRepository<User, Long> {

    long countByEmail(String email);
    User getByEmail(String email);
    Optional<User> findById(Long userId);
}
