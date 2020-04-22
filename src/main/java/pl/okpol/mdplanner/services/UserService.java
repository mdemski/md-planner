package pl.okpol.mdplanner.services;

import ch.qos.logback.core.util.COWArrayList;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.okpol.mdplanner.dto.UserDTO;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.repositories.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    public COWArrayList<Object> findAllUsers;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getUserByEmail(String email) {
        return userRepository.getByEmail(email);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void registerUser(UserDTO data) {
        User user = new User();
        user.setEmail(data.getEmail());
        String encodedPassword = passwordEncoder.encode(data.getPassword());
        user.setPassword(encodedPassword);
        user.setFirstName(data.getFirstName());
        user.setRole(data.getRole());
        user.setActivated(data.isActivated());
        user.setUuid(data.getUuid());
        List<User> users = new ArrayList<>();
        users.add(user);
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
