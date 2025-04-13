package org.spring_security.loginregister.service;

import org.spring_security.loginregister.model.AppUsers;
import org.spring_security.loginregister.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomLoginUserDetailsService implements UserDetailsService {
    private final AppUserRepository repository;

    public CustomLoginUserDetailsService(AppUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUsers user = repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
        return new CustomerUserLoginDetails(user);
    }

}
