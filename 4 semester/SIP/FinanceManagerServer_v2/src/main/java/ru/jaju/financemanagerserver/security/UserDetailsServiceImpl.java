package ru.jaju.financemanagerserver.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.jaju.financemanagerserver.data.user.User;
import ru.jaju.financemanagerserver.data.repository.UserRepository;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {
    private UserRepository userRepository;

    @Autowired
    UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDataHandler(user.getId(), user.getLogin(), user.getPassword(), Collections.emptyList());
    }

    public boolean isUserExist(int id) {
        return userRepository.existsById(id);
    }

    public User loadUserById(int id) {
        return userRepository.findById(id).get();
    }
}
