package by.en.dao.impl;

import by.en.dao.LearnedDAO;
import by.en.entity.Learned;
import by.en.entity.User;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LearnedDAOImpl extends BaseDAOImpl<Learned> implements LearnedDAO {

    @Transactional
    @Override
    public List<Learned> getLearnedByUser(User user) {

        Query query = getSession().createQuery("select l from Learned l where l.user=:user");
        query.setParameter("user", user).getResultList();
        return (List<Learned>) query.list();
    }

}



//    String hql = "FROM User where name = :paramName";
//    Query query = session.createQuery(hql);
//    query.setParameter("paramName", "Alex");
//    List<User> users = query.list();
