package org.spring_security.loginregister.repository;

import org.spring_security.loginregister.model.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository <AppUsers,Long> {
    Optional<AppUsers> findByUsername(String username);
}
