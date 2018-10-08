package by.en.dao;

import by.en.entity.Learned;
import by.en.entity.MurphyUnit;
import by.en.entity.User;

import java.util.List;
import java.util.Set;

public interface LearnedDAO extends BaseDao<Learned> {
    List<Learned> getLearnedByUser(User user);
}
