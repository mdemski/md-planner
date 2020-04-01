package pl.okpol.mdplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.okpol.mdplanner.dto.UserLoginDTO;
import pl.okpol.mdplanner.services.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/logowanie")
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareLoginPage(Model model) {
        model.addAttribute("loginData", new UserLoginDTO());
        return "login";
    }

    @PostMapping
    public String processLoginPage(@ModelAttribute("loginData") @Valid UserLoginDTO loginData, BindingResult result) {
        if (userService.getUserByEmail(loginData.getEmail()).isActivated()) {
            result.rejectValue("email", null, "Konto nie zostało aktywowane. Aktywuj konto.");
            return "login";
        } else {
            if (!result.hasErrors()) {
                return "redirect:/zamowienia";
            } else {
                if (!(loginData.getPassword().equals(userService.getUserByEmail(loginData.getEmail())))) {
                    result.rejectValue("password", null, "Podany email lub hasło są niepoprawne.");
                    return "login";
                } else if (!(loginData.getEmail().equals(userService.getUserByEmail(loginData.getEmail())))) {
                    result.rejectValue("email", null, "Podany email lub hasło są niepoprawne.");
                    return "login";
                } else {
                    result.rejectValue("email", null, "Podany email lub hasło są niepoprawne.");
                    return "login";
                }
            }
        }
    }
}
