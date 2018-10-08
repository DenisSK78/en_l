package by.en.service;

import by.en.entity.Learned;
import by.en.entity.User;

import java.util.List;

public interface LearnedService {
    List<Learned> getLearnedByUser(User user);

    void saveLearned(Learned learned);
}
