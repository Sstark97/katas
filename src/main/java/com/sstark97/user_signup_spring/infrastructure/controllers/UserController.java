package com.sstark97.user_signup_spring.infrastructure.controllers;

import com.sstark97.user_signup_spring.application.services.UserSignUpService;
import com.sstark97.user_signup_spring.domain.model.UserSignUp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserSignUpService signUpService;

    public UserController(UserSignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping("/sign_up")
    ResponseEntity<String> signUp(@RequestBody UserSignUp user) {
        return ResponseEntity.ok().build();
    }
}
