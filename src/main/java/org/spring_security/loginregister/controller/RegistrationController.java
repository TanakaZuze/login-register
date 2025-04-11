package org.spring_security.loginregister.controller;

import org.spring_security.loginregister.model.AppUsers;
import org.spring_security.loginregister.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RegistrationController {
    private final AppUserService appUserService;

    public RegistrationController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppUsers registerUser(@RequestBody AppUsers user){
        return appUserService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUsers user){
        return appUserService.login(user);
    }
}
