package pl.okpol.mdplanner.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.okpol.mdplanner.dto.UserDTO;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public Optional findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean isEmailAvailable(String email) {
        long countEmail = userRepository.countByEmail(email);
        if (countEmail > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void registerUser(UserDTO data) {
        User user = new User();
        user.setEmail(data.getEmail());
        String encodedPassword = passwordEncoder.encode(data.getPassword());
        user.setPassword(encodedPassword);
        user.setFirstName(data.getFirstName());
        user.setRole(data.getRole());
        user.setActivated(data.isActivated());
        List<User> users = new ArrayList<>();
        users.add(user);
        userRepository.save(user);
    }

    public boolean checkEmailUUID(String userEmail, String uuid) {
        return userRepository.getByEmail(userEmail).getUuid().equals(uuid);
    }

    public void setToActivated(User userByEmail) {
        userByEmail.setActivated(true);
        userRepository.save(userByEmail);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }
}
