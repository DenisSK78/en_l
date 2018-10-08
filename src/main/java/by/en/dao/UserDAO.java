package by.en.dao;

import by.en.entity.User;

public interface UserDAO extends BaseDao<User> {
    User findByEmail(String email);
}
