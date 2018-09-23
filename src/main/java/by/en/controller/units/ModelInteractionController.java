package by.en.controller.units;

import by.en.entity.Worlds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("sessionParam")
public class ModelInteractionController {

//    @ModelAttribute
//    public void prepopulateWorlds(Model model) {
//        Worlds worlds = new Worlds();
//        worlds.setEnWorld("Soon");
//        worlds.setRuWorld("скоро");
//        worlds.setEnPhrase("I getting up very soon.");
//        worlds.setRuPhrase("Я очень скоро встаю.");
//
//        model.addAttribute("worlds", worlds);
//    }

    @ModelAttribute("worlds")
    public Worlds prepopulateUser() {
        Worlds worlds = new Worlds();
        worlds.setEnWorld("Soon");
        worlds.setRuWorld("скоро");
        worlds.setEnPhrase("I getting up very soon.");
        worlds.setRuPhrase("Я очень скоро встаю.");
        return worlds;
    }

    @GetMapping("/model")
    public String showModelPage(Model model) {
        System.out.println("-------1--------");
        model.addAttribute("sessionParam", "Wild Session Param");
        return "model";
    }

    @GetMapping("/secondModel")
    public String showModelPage2(Model model) {
        System.out.println("-------2--------");
        System.out.println(model.containsAttribute("sessionParam"));
        return "model";
    }
}
