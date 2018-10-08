package by.en.controller.units.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @PostMapping("/register")
    public String register(String firstName, String lastName) {
        System.out.println(firstName + " " + lastName);
        return "redirect:/register";
    }

    @GetMapping("/register")
    public String showRegistrationPage() {
        return "registration";
    }
}
