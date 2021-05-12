package com.example.funproject.controller;


import com.example.funproject.request.RegistrationRequest;
import com.example.funproject.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegistrationRequest registrationRequest){
        registrationService.signup(registrationRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

}
