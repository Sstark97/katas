package com.sstark97.user_signup_spring.application.services;

import com.sstark97.user_signup_spring.domain.model.UserSignUp;
import com.sstark97.user_signup_spring.domain.repositories.UserSignUpRepository;

public class UserSignUpService {
    private final UserSignUpRepository repository;

    public UserSignUpService(UserSignUpRepository repository) {
        this.repository = repository;
    }

    public String save(UserSignUp user) {
        return "The email have a bad format";
    }
}
