package by.en.service;

import by.en.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getUserByEmail(String email);

    void saveUser(User user);

    User getUserById(Long userId);

    List<User> getAll();
}
