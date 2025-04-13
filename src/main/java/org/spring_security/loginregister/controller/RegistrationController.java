package org.spring_security.loginregister.controller;

import org.spring_security.loginregister.model.AppUsers;
import org.spring_security.loginregister.service.AppUserRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {
    private final AppUserRegisterService service;

    public RegistrationController(AppUserRegisterService service) {
        this.service = service;
    }

    @PostMapping("/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public AppUsers registerUser(@RequestBody AppUsers user){
        return service.registerUser(user);
    }

    @GetMapping("/greeting")
    public String greeting(AppUsers user){
        return "Hello World "+user.getUsername();
    }

//    read all users
    @GetMapping("/users")
    public List<AppUsers> getAllUsers(){
        return service.getAllUsers();
    }
}
