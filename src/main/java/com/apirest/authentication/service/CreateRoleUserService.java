package com.apirest.authentication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.authentication.dto.CreateUserRoleDTO;
import com.apirest.authentication.models.Role;
import com.apirest.authentication.models.User;
import com.apirest.authentication.repository.UserRepository;

@Service
public class CreateRoleUserService {
    @Autowired
    UserRepository userRepository;

    public User execute(CreateUserRoleDTO createUserRoleDTO) {

        Optional<User> userExists = userRepository.findById(createUserRoleDTO.getIdUser());
        List<Role> roles = new ArrayList<>();

        if (userExists.isEmpty()) {
            throw new Error("User does not exists!");
        }

        roles = createUserRoleDTO.getIdsRoles().stream().map(role -> {
            return new Role(role);
        }).collect(Collectors.toList());

        User user = userExists.get();

        user.setRoles(roles);

        userRepository.save(user);

        return user;

    }
}
