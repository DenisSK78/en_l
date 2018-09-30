package by.en.service;

import by.en.dao.UserDAO;
import by.en.entity.Role;
import by.en.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
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
        //if need more roles than one, set them
    }
}
