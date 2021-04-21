package com.example.funproject.controller;


import com.example.funproject.models.User;
import com.example.funproject.repositories.UserRepository;
import com.example.funproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/user")
    public @ResponseBody List<User> returnUsers(){
        return userService.getAllUsers();

    }

}
