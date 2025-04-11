package org.spring_security.loginregister.config;

import org.spring_security.loginregister.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
//    this bean method is for directing the security fitter chain and customizING PAGE
    @Bean
    public SecurityFilterChain  securityFilterChain(HttpSecurity httpSecurity) throws Exception{
         httpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                        request -> request
                                .requestMatchers("/register","/login").permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

         return httpSecurity.build();
    }
}
