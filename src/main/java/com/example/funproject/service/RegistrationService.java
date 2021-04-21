package com.example.funproject.service;


import com.example.funproject.models.User;
import com.example.funproject.repositories.UserRepository;
import com.example.funproject.request.RegistrationRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegistrationService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Transactional
    public void signup(RegistrationRequest registrationRequest){

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        
    }
}
