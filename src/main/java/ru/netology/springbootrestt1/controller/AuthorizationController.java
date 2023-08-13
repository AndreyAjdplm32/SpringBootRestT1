package ru.netology.springbootrestt1.controller;



import org.springframework.web.bind.annotation.*;
import ru.netology.springbootrestt1.client.Client;
import ru.netology.springbootrestt1.service.Authorities;
import ru.netology.springbootrestt1.service.AuthorizationService;

import java.util.List;


@RestController
@RequestMapping("/")
public class AuthorizationController {
private final AuthorizationService service;
public AuthorizationController (AuthorizationService service) {
    this.service = service;
}


    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam ("user") String user, @RequestParam ("password") String password) {
        return service.getAuthorities(user, password);
    }


    @PostMapping("/registration")
    public void userRegistration(@RequestBody Client client) {
        service.register(client);
    }
}