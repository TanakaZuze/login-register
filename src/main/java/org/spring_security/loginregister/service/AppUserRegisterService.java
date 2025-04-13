package org.spring_security.loginregister.service;

import org.spring_security.loginregister.model.AppUsers;
import org.spring_security.loginregister.repository.AppUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserRegisterService {
    private final AppUserRepository repository;

    public AppUserRegisterService(AppUserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AuthenticationManager authenticationManager;



    //    create user
    public AppUsers registerUser(AppUsers user){
        user.setPassword(bCryptPasswordEncoder
                .encode(user.getPassword()));
        return repository.save(user);
    }

//    read all users
    public List<AppUsers> getAllUsers(){
        return repository.findAll();
    }

    public String verify(AppUsers user){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUsername(),user.getPassword()
        ));
        return "";
    }


}
