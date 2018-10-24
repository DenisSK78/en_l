package by.en.controller.example;

import by.en.entity.Vocabulary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

    @GetMapping("/demo/{id}")
    public String getDemo(Model model
            , @PathVariable("id") Long id
            , @RequestParam("customParameter") String parameter
            , @CookieValue("JSESSIONID") String cookie
            , @RequestHeader("CustomHeader")  String customHeader
    ){

        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setEnWorld("Soon");
        vocabulary.setRuWorld("скоро");
        vocabulary.setEnPhrase("I getting up very soon.");
        vocabulary.setRuPhrase("Я очень скоро встаю.");

        System.out.println(id);
        System.out.println(parameter);
        System.out.println(cookie);
        System.out.println(customHeader);

        model.addAttribute("world", vocabulary);
        return "demo";
    }

    @GetMapping("/demo")
    public String getDemo(Model model){
        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setEnWorld("Soon");
        vocabulary.setRuWorld("скоро");
        vocabulary.setEnPhrase("I getting up very soon.");
        vocabulary.setRuPhrase("Я очень скоро встаю.");
        model.addAttribute("world", vocabulary);
        return "demo";
    }
}
