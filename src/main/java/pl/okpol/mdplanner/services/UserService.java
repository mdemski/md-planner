package pl.okpol.mdplanner.services;

import org.springframework.stereotype.Service;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public Optional findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail();
    }
}
