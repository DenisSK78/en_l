package by.en.controller;

import by.en.entity.User;
import by.en.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin")
    public String showAdminPage(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);
        return "admin";
    }
}
