package org.spring_security.loginregister.model;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name="users")
public class AppUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique=true,nullable=false)
    private String username;
    private String password;

//    getters

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
