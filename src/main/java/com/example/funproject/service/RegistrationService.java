package com.example.funproject.service;


import com.example.funproject.models.User;
import com.example.funproject.models.VerificationToken;
import com.example.funproject.repositories.UserRepository;
import com.example.funproject.repositories.VerificationTokenRepository;
import com.example.funproject.request.RegistrationRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class RegistrationService {

    private VerificationTokenRepository verificationTokenRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void signup(RegistrationRequest registrationRequest){

        User user = new User();
        user.setUsername(registrationRequest.getUsername());
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        userRepository.save(user);
        String token = generateToken(user);
    }

    private String generateToken(User user){
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    private String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    @Transactional
    void UserEnable(VerificationToken verificationToken){
        String username = verificationToken.getUser().getUsername();
        User user = userRepository.findByUsername(username).orElseThrow();
        userRepository.save(user);
    }
}
