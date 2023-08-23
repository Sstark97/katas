package com.sstark97.user_signup_spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @PostMapping
    ResponseEntity<String> signUp() {
        return ResponseEntity.ok().build();
    }
}
