package api.controller;


import api.entity.User;
import api.logging.LogUserRegistration;
import api.repository.UserRepository;
import api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/")
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }



    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String showProfile(Model model, Principal principal) {
        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)

    public String processRegistration(@Valid User user, Errors errors) {

        if (errors.hasErrors()) return "registerForm";

        userService.saveUser(user);

        return "redirect:/";
    }


}
