package pl.okpol.mdplanner.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.services.UserService;

import java.security.Principal;

@ControllerAdvice
public class GlobalController {

    private UserService userService;

    public GlobalController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("loggedUser")
    public User getLoggedUser() {
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByEmail(principal.getName());
    }
}
