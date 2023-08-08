package ru.netology.springbootrestt1.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootrestt1.error.InvalidCredentials;
import ru.netology.springbootrestt1.error.UnauthorizedUser;
import ru.netology.springbootrestt1.repository.UserRepository;


import java.util.List;


@Service
public class AuthorizationService {
    private  UserRepository userRepository;

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }

    public void register(String user, String password) {
        userRepository.userRegistration(user, password);
    }


}