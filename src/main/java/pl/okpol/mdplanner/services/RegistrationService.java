package pl.okpol.mdplanner.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.okpol.mdplanner.dto.RegistrationFormDTO;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RegistrationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isEmailAvailable(String email) {
        long countEmail = userRepository.countByEmail(email);
        if (countEmail > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void registerUser(RegistrationFormDTO data) {
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
    }
}
