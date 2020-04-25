package pl.okpol.mdplanner.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.okpol.mdplanner.dto.UserDTO;
import pl.okpol.mdplanner.mappers.UserMapper;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.services.EmailService;
import pl.okpol.mdplanner.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class RegistrationController {

    private UserService userService;
    private EmailService emailService;
    private UserMapper userMapper;

    public RegistrationController(UserService userService, EmailService emailService, UserMapper userMapper) {
        this.userService = userService;
        this.emailService = emailService;
        this.userMapper = userMapper;
    }

    @GetMapping("/list-of-roles")
    public List<String> prepareRegistrationForm() {
        List<String> roles = new ArrayList<>();
        roles.add("zaopatrzenie");
        roles.add("handel");
        roles.add("produkcja");
        roles.add("jakość");
        return roles;
    }

    @GetMapping
    public List<User> prepareAllUsersList() {
        return userService.findAllUsers();
    }

    @PostMapping
    public User registerUser(@Valid @RequestBody UserDTO userDTO,
                             BindingResult result,
                             HttpServletRequest servletRequest) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.toString());
            }
        }
        String serverAddress = servletRequest.getRequestURL()
                .substring(0, servletRequest.getRequestURL().length() - servletRequest.getRequestURI().length())
                + servletRequest.getServletContext().getContextPath();
        emailService.sendActiveUser(userDTO.getEmail(), userDTO.getUuid(), serverAddress);
        userService.registerUser(userDTO);
        return userMapper.convertToUserEntity(userDTO);
    }

    @GetMapping("/activate/{activationKey}")
    public String processActivationUser(@PathVariable String activationKey) {
        String[] emailAndUuid = activationKey.split("&");
        String email = emailAndUuid[0];
        String uuid = emailAndUuid[1];
        User user = userService.getUserByEmail(email);
        if (user != null) {
            if (user.getUuid().equals(uuid)) {
                user.setActivated(true);
                userService.updateUser(user);
            }
        }
        return "Udało się aktywować konto. Zaloguj się";
    }
}
