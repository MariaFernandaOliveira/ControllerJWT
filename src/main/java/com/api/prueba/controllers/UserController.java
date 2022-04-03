package com.api.prueba.controllers;

import com.api.prueba.dtos.UserDto;
import com.api.prueba.model.User;
import com.api.prueba.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.time.LocalDateTime;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/user")
public class UserController {

    final UserService userService;
    final PasswordEncoder encoder;

    public UserController(UserService parkingSpotService, PasswordEncoder encoder) {
        this.userService = parkingSpotService;
        this.encoder = encoder;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto) {
        if (userService.existsByUsername(userDto.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Username is already in use!");
        }
        var user = new User();
        userDto.setHashed_password(encoder.encode(userDto.getHashed_password()));
        BeanUtils.copyProperties(userDto, user);
        user.setToken_expiration(LocalDateTime.now().plusDays(1));
        user.setToken(user.getToken());
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }
}
