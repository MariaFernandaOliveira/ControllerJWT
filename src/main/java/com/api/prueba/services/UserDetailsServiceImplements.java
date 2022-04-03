package com.api.prueba.services;

import com.api.prueba.data.DataUserDetails;
import com.api.prueba.model.User;
import com.api.prueba.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class UserDetailsServiceImplements implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImplements(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = repository.findByUsername(username);
        if (userOptional.isEmpty()){
            throw new UsernameNotFoundException("Username [" + username +"] doesn't exist" );
        }

        return new DataUserDetails(userOptional);
    }
    }

