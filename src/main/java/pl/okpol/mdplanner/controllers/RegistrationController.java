package pl.okpol.mdplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.okpol.mdplanner.dto.UserDTO;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.services.EmailService;
import pl.okpol.mdplanner.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rejestracja")
public class RegistrationController {

    private UserService userService;
    private EmailService emailService;

    public RegistrationController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        List<String> roles = new ArrayList<>();
        roles.add("zaopatrzenie");
        roles.add("handel");
        roles.add("produkcja");
        roles.add("jakość");
        model.addAttribute("data", new UserDTO(false));
        model.addAttribute("roles", roles);
        return "registration";
    }

    @PostMapping()
    public String processRegistrationPage(@ModelAttribute("data") @Valid UserDTO data, BindingResult result, HttpServletRequest servletRequest) {
        if (result.hasErrors()) { //walidacja poprawności wpisanych danych
            return "registration";
        } else if (data.getFirstName().equals("")) {
            result.rejectValue("firstName", null, "Podaj imię");
            return "registration";
        } else if (!data.getPassword().equals(data.getRePassword())) { //walidacja poprawności haseł
            result.rejectValue("rePassword", null, "Hasło i powtórzone hasło muszą być takie same");
            return "registration";
        } else if (!userService.isEmailAvailable(data.getEmail())) { //walidacja zajętości email
            result.rejectValue("email", null, "Email jest już zajęty");
            return "registration";
        } else {
            String serverAddress = servletRequest.getRequestURL().substring(0, servletRequest.getRequestURL().length() - servletRequest.getRequestURI().length()) + servletRequest.getServletContext().getContextPath();
            userService.registerUser(data);
            emailService.sendActiveUser(data.getEmail(), serverAddress);
            return "redirect:/proces-rejestracji";
        }
    }

    @GetMapping("/proces-rejestracji")
    public String registrationProcessPage() {
        return "registerProcess";
    }

    @GetMapping("/proces-rejestracji?userEmail={userEmail}&userUUID={UUID}")
    public String registrationProcessPage(@RequestParam(required = false, name = "UUID") String UUID,
                                          @RequestParam(required = false, name = "userEmail") String userEmail,
                                          Model model) {
        if (userEmail != null) {
            if (userService.checkEmailUUID(userEmail, UUID)) {
                model.addAttribute("successMessage", "Konto zarejestrowane poprawnie");
                User user = userService.getUserByEmail(userEmail);
                userService.setToActivated(user);
                userService.updateUser(user);
            } else {
                model.addAttribute("errorMessage", "Nie udało się poprawnie założyć konta, spróbuj ponownie");
            }
        }
        return "login";
    }
}
