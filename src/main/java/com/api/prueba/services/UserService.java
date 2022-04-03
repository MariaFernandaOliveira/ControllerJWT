package com.api.prueba.services;

import com.api.prueba.model.User;
import com.api.prueba.repositories.UserRepository;
import com.api.prueba.security.JWTauthenticationFilter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {

    final UserRepository userRepository;
    final JWTauthenticationFilter jwTauthenticationFilter;

    public UserService(UserRepository userRepository, JWTauthenticationFilter jwTauthenticationFilter) {
        this.userRepository = userRepository;
        this.jwTauthenticationFilter = jwTauthenticationFilter;
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }


    public User save(String token){ return userRepository.save(token);}

}

