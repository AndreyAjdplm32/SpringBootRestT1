package ru.netology.springbootrestt1.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootrestt1.error.ErrorRegistration;
import ru.netology.springbootrestt1.service.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.netology.springbootrestt1.service.Authorities.*;

@Repository
public class UserRepository {
    private final Map<String, String> userMap = new ConcurrentHashMap<>();
    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> authorities = new ArrayList<>();
        if (userMap.containsKey(user) && userMap.get(user).equals(password)) {
            authorities.add(Authorities.READ);
            authorities.add(Authorities.WRITE);
            authorities.add(Authorities.DELETE);
        }
        return authorities;
    }

    public void userRegistration(String user, String password){
        if (!userMap.containsKey(user)) {
            userMap.put(user, password);
        } else throw new ErrorRegistration("The name is taken");
    }
}