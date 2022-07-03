package com.apirest.authentication.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.authentication.dto.CreateUserRoleDTO;
import com.apirest.authentication.models.User;
import com.apirest.authentication.service.CreateRoleUserService;
import com.apirest.authentication.service.CreateUserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    CreateUserService createUserService;

    @Autowired
    CreateRoleUserService createRoleUserService;

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        // String uuidString  = "81e47e1c-a566-11ec-b909-0242ac120002";
        // UUID uuidObj = UUID.fromString(uuidString);
        // System.out.println(uuidObj);
        // List<UUID> list = ['81e47e1c-a566-11ec-b909-0242ac120002'];
        // list.add(uuidObj);

        // CreateUserRoleDTO userRole = new CreateUserRoleDTO();
        // userRole.setIdUser(user.getId());
        // userRole.setIdsRoles(list);
        // createRoleUserService.execute(userRole)
        return createUserService.execute(user);
    }

    @PostMapping("/role")
    public User role(@RequestBody CreateUserRoleDTO createUserRoleDTO) {
        return createRoleUserService.execute(createUserRoleDTO);
    }
}
