package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthenticatiionController {

    
    private final AuthenticationService authenticationService;

    public AuthenticatiionController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public String authenticate() {

        return authenticationService.authenticate();
    }
    
}
