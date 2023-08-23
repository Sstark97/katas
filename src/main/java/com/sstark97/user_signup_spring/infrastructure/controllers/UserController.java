package com.sstark97.user_signup_spring.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping("/sign_up")
    ResponseEntity<String> signUp() {
        return ResponseEntity.ok().build();
    }
}
