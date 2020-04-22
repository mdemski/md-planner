package pl.okpol.mdplanner.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import pl.okpol.mdplanner.dto.UserLoginDTO;
import pl.okpol.mdplanner.mappers.UserMapper;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.services.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/login")
@CrossOrigin
public class LoginController {

    private UserService userService;
    private UserMapper userMapper;

    public LoginController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping
    public User processLoginPage(@Valid @RequestBody UserLoginDTO loginData, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println(error.toString());
            }
        }
        User logInUser = userService.findByEmail(loginData.getEmail());
        if (logInUser == null) {
            System.out.println("Failed to login, no user in database.");
        } else if (logInUser.isActivated()) {
            System.out.println("Login success, current user: " + logInUser.getFirstName());
        } else if (!loginData.getPassword().equals(logInUser.getPassword())){
            System.out.println("Failed to login, bad credentials.");
        } else {
            System.out.println("Failed to login.");
        }
        return userMapper.convertToUserEntity(loginData.getEmail());
    }
}
