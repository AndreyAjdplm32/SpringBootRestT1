package ru.netology.springbootrestt1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootrestt1.service.Authorities;
import ru.netology.springbootrestt1.service.AuthorizationService;

import java.util.List;


@RestController
public class AuthorizationController {

    @Autowired
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam ("user") String user, @RequestParam ("password") String password) {
        return service.getAuthorities(user, password);
    }


    @GetMapping("/registration")
    public void userRegistration(@RequestParam("user") String user, @RequestParam("password") String password) {
        service.register(user, password);
    }
}