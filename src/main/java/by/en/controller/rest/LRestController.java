package by.en.controller.rest;

import by.en.entity.Learned;
import by.en.entity.User;
import by.en.service.LearnedService;
import by.en.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class LRestController {

    private LearnedService learnedService;
    private UserService userService;

    @Autowired
    public LRestController(LearnedService learnedService, UserService userService) {
        this.learnedService = learnedService;
        this.userService = userService;
    }

    @GetMapping("learned")
    private List<Learned> getLearneds(){
        User user = userService.getUserByEmail("user2@user2.by");
        List<Learned> dbListLearned = learnedService.getLearnedByUser(user);
        List<Integer> integers = dbListLearned
                .stream()
                .map(e -> e.getMurphyUnit().getNumber())
                .collect(Collectors.toList());

        List<Learned> threeRandom = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            threeRandom.add(dbListLearned.get(new Random().nextInt(integers.size())));
        }
        return threeRandom;
    }
}
