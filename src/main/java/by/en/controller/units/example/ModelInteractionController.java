package by.en.controller.units.example;

import by.en.entity.Vocabulary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionParam")
public class ModelInteractionController {

    @ModelAttribute("worlds")
    public Vocabulary prepopulateUser() {
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setEnWorld("Soon");
        vocabulary.setRuWorld("скоро");
        vocabulary.setEnPhrase("I getting up very soon.");
        vocabulary.setRuPhrase("Я очень скоро встаю.");
        return vocabulary;
    }

    @GetMapping("/model")
    public String showModelPage(Model model) {
        model.addAttribute("sessionParam", "Wild Session Param");
        return "model";
    }

    @GetMapping("/secondModel")
    public String showModelPage2(Model model) {
        System.out.println(model.containsAttribute("sessionParam"));
        return "model";
    }
}
