package by.en.service.implementation;

import by.en.dao.UserDAO;
import by.en.entity.Role;
import by.en.entity.User;
import by.en.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public User getUserByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public User getUserById(Long userId) {
        return userDAO.getById(userId);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        return userDAO.findAll();
    }


    /**
    * This is method for security.
    */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userDAO.findByEmail(email);
       if (user == null){
           throw new UsernameNotFoundException("User doesn't exist!");
       }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                generateAuthorities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> generateAuthorities(Role role) {
        return Collections.singleton(new SimpleGrantedAuthority(role.toString()));
    }
}
