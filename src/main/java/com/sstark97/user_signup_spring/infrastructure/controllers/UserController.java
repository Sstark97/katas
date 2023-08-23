package com.sstark97.user_signup_spring.infrastructure.controllers;

import com.sstark97.user_signup_spring.application.services.UserSignUpService;
import com.sstark97.user_signup_spring.domain.model.ApiError;
import com.sstark97.user_signup_spring.domain.model.UserSignUp;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserSignUpService signUpService;

    public UserController(UserSignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @PostMapping("/sign_up")
    ResponseEntity<String> signUp(@RequestBody UserSignUp user) {
        Either<ApiError, String> saveResult = signUpService.save(user);

        if(saveResult.isLeft()) {
            ApiError error = saveResult.getLeft();
            return new ResponseEntity<>(error.getMessage(), error.getStatusCode());
        }
        return ResponseEntity.ok().build();
    }
}
