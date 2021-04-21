package com.example.funproject.service;


import com.example.funproject.models.User;
import com.example.funproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public void saveDetails(User user){
        User u = new User();
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        u.setEmail(user.getEmail());
        userRepository.save(user);
    }

    public List<User> getAllUsers(){

        return userRepository.findAll();
    }

}
