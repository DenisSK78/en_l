package by.en.dao;

import by.en.entity.User;

public interface UserDAO extends BaseDAO<User> {
    User findByEmail(String email);
}
