package com.apirest.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apirest.authentication.models.User;
import com.apirest.authentication.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User existsUser = repository.findByUsernameFetchRoles(username);
        // System.out.println();
        // System.out.println("USER"+existsUser);

        if (existsUser == null) {
            throw new Error("User does not exists!");
        }
        
        return UserPrincipal.create(existsUser);
    }
    
}
