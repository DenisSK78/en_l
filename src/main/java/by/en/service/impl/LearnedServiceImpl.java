package by.en.service.impl;

import by.en.dao.LearnedDAO;
import by.en.entity.Learned;
import by.en.entity.User;
import by.en.service.LearnedService;
import by.en.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LearnedServiceImpl implements LearnedService {

    private final LearnedDAO learnedDAO;
    private final UserService userService;

    @Autowired
    public LearnedServiceImpl(LearnedDAO learnedDAO, UserService userService) {
        this.learnedDAO = learnedDAO;
        this.userService = userService;
    }

    @Override
    @Transactional
    public List<Learned> getLearnedByUser(User u) {
        User user = userService.getUserById(u.getId());
        return new ArrayList<>(user.getLearnedSet());
    }

    @Override
    @Transactional
    public void saveLearned(Learned learned) {
        learnedDAO.save(learned);
    }
}
