package org.spring_security.loginregister.service;

import org.spring_security.loginregister.model.AppUsers;
import org.spring_security.loginregister.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {
    private final AppUserRepository repository;

    public AppUserService(AppUserRepository repository) {
        this.repository = repository;
    }


    //    create user
    public AppUsers registerUser(AppUsers user){
        return repository.save(user);
    }

//    login
    public String login(AppUsers user){
        Optional<AppUsers> users=repository.findByUsername(user.getUsername());
        if(users.isPresent()){
            return "success login "+user.getUsername();
        }
        else
            return "fail login,invalid credentials "+user.getUsername()+" does not exist";
    }
}
