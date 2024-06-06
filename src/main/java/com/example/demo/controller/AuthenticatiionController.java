package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class AuthenticatiionController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("authenticate")
    public String authenticate(Authentication authentication) {

        return authenticationService.authenticate(authentication);
    }
    
}
