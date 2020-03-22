package pl.okpol.mdplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.okpol.mdplanner.dto.UserLoginDTO;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/logowanie")
public class LoginController {

    private UserService userService;

    @GetMapping
    public String prepareLoginPage(Model model, Principal principal) {
        model.addAttribute("loginData", new UserLoginDTO());
        return "login";
    }

    @PostMapping
    public String processLoginPage(@Valid UserLoginDTO userLoginDTO, BindingResult result) {
        if (!result.hasErrors()) {
            User userName = userService.getUserByEmail(userLoginDTO.getEmail());
            return "redirect:/zamowienia";
        } else {
            return "login";
        }
    }
}
