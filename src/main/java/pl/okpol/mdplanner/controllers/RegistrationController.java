package pl.okpol.mdplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.okpol.mdplanner.dto.RegistrationFormDTO;
import pl.okpol.mdplanner.services.EmailService;
import pl.okpol.mdplanner.services.RegistrationService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rejestracja")
public class RegistrationController {

    private RegistrationService registrationService;
    private EmailService emailService;

    public RegistrationController(RegistrationService registrationService, EmailService emailService) {
        this.registrationService = registrationService;
        this.emailService = emailService;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        List<String> roles = new ArrayList<>();
        roles.add("zaopatrzenie");
        roles.add("handel");
        roles.add("produkcja");
        roles.add("zaopatrzenie");
        model.addAttribute("data", new RegistrationFormDTO(false));
        model.addAttribute("roles", roles);
        return "registration";
    }

    @PostMapping()
    public String processRegistrationPage(@ModelAttribute("data") @Valid RegistrationFormDTO data, BindingResult result, HttpServletRequest servletRequest) {
        if (result.hasErrors()) { //walidacja poprawności wpisanych danych
            return "registration";
        }
        if (!data.getPassword().equals(data.getRePassword())) { //walidacja poprawności haseł
            result.rejectValue("rePassword", null, "Hasło i powtórzone hasło muszą być takie same");
            return "registration";
        }
        if (!registrationService.isEmailAvailable(data.getEmail())){ //walidacja zajętości email
            result.rejectValue("email", null, "Email jest już zajęty");
            return "registration";
        }

        String serverAddress = servletRequest.getRequestURL().substring(0,servletRequest.getRequestURL().length()-servletRequest.getRequestURI().length())+servletRequest.getServletContext().getContextPath();
        registrationService.registerUser(data);
        emailService.sendActiveUser(data.getEmail(), serverAddress);

        return "redirect:/proces-rejestracji";
    }
}
