package by.en.dao.impl;

import by.en.dao.UserDAO;
import by.en.dao.base.BaseDAOImpl;
import by.en.entity.User;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

    @Override
    public User findByEmail(String email) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        User user = session.createQuery("select u from User u where u.email=:email", User.class)
                .setParameter("email", email).uniqueResult();

        session.getTransaction().commit();
        session.close();
        return user;
    }
}
