package com.example.funproject.service;


import com.example.funproject.models.User;
import com.example.funproject.repositories.UserRepository;
import com.example.funproject.request.AuthResponse;
import com.example.funproject.request.LoginRequest;
import com.example.funproject.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public void signup(RegistrationRequest registrationRequest) {

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(encodePassword(registrationRequest.getPassword()));
        userRepository.save(user);
    }


    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }




}