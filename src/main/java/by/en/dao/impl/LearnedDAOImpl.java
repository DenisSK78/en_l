package by.en.dao.impl;

import by.en.dao.LearnedDAO;
import by.en.entity.Learned;
import by.en.entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class LearnedDAOImpl extends BaseDAOImpl<Learned> implements LearnedDAO {

//    @Override
//    public List<Learned> getLearnedByUser(User user) {
//        List learnedList = getSession().createQuery("select l from Learned l where l.user=:user")
//            .setParameter("user", user).getResultList();
//        return learnedList.size()==0 ? Collections.emptyList() : learnedList;
//    }

}
