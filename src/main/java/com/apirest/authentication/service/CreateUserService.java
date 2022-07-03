package com.apirest.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apirest.authentication.models.User;
import com.apirest.authentication.repository.UserRepository;

@Service
public class CreateUserService {
    @Autowired
    UserRepository userRepository;

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public User execute(User user) {

        User existsUser = userRepository.findByUsernameFetchRoles(user.getUsername());

        if (existsUser != null) {
            throw new Error("User already exists!");
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));

        User createdUser = userRepository.save(user);

        return createdUser;
    }
}
