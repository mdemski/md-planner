package pl.okpol.mdplanner.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.okpol.mdplanner.dto.UserLoginDTO;
import pl.okpol.mdplanner.model.User;
import pl.okpol.mdplanner.services.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    private UserService userService;

    @GetMapping
    public String prepareHomePage(Model model, Principal principal) {
        if (principal != null){
            Long userId = userService.getUserByEmail(principal.getName()).getId();
            model.addAttribute("userId", userId);
        }
        return "index";
    }

    @GetMapping("/logowanie")
    public String prepareLoginPage(Model model){
        model.addAttribute("loginData", new UserLoginDTO());
        return "login";
    }

    @PostMapping("/logowanie")
    public String processLoginPage(@Valid UserLoginDTO userLoginDTO, BindingResult result){
        if (!result.hasErrors()) {
            User userName = userService.getUserByEmail(userLoginDTO.getEmail());
            Long userId = userName.getId();
            return "redirect:/zamowienia";
        } else {
            return "login";
        }
    }
}
