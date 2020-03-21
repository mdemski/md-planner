package pl.okpol.mdplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.okpol.mdplanner.dto.RegistrationFormDTO;
import pl.okpol.mdplanner.services.RegistrationService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/rejestracja")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        List<String> roles = new ArrayList<>();
        roles.add("zaopatrzenie");
        roles.add("handel");
        roles.add("produkcja");
        model.addAttribute("data", new RegistrationFormDTO());
        model.addAttribute("roles", roles);
        return "registration";
    }

    @PostMapping()
    public String processRegistrationPage(@ModelAttribute("data") @Valid RegistrationFormDTO data, BindingResult result) {
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
        registrationService.registerUser(data);
        return "redirect:/login";
    }
}
