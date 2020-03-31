package pl.okpol.mdplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.okpol.mdplanner.services.RegistrationService;

@Controller
@RequestMapping("/proces-rejestracji")
public class RegistrationProcessController {

    private RegistrationService registrationService;

    public RegistrationProcessController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String registrationProcessPage(@RequestParam(required = false) String UUID,
                                          @RequestParam(required = false) String userEmail,
                                          Model model) {
        if (userEmail != null) {
            if (registrationService.checkEmailUUID(userEmail, UUID)) {
                model.addAttribute("successMessage", "Konto zarejestrowane poprawnie");
            }
            else {
                model.addAttribute("errorMessage", "Nie udało się poprawnie założyć konta, spróbuj ponownie");
            }
        }

        return "registerProcess";
    }
}
