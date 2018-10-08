package by.en.dao.impl;

import by.en.dao.UserDAO;
import by.en.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

    @Override
    @Transactional
    public User findByEmail(String email) {
        return getSession().createQuery("select u from User u where u.email=:email", User.class)
                .setParameter("email", email).uniqueResult();
    }
}

