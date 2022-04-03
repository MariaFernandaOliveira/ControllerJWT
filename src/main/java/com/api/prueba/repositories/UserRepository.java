package com.api.prueba.repositories;

import com.api.prueba.model.User;
import com.api.prueba.security.JWTauthenticationFilter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    public boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

    User save (String token);
}
