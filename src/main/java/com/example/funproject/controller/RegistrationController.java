package com.example.funproject.controller;


import com.example.funproject.request.RegistrationRequest;
import com.example.funproject.service.RegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class RegistrationController {


    private RegistrationService registrationService;

    @PostMapping("/register")
    public ResponseEntity signup(@RequestParam RegistrationRequest registrationRequest){
        registrationService.signup(registrationRequest);
        return new ResponseEntity(OK);
    }

}
