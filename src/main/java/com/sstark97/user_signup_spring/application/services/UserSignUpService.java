package com.sstark97.user_signup_spring.application.services;

import com.sstark97.user_signup_spring.domain.model.ApiError;
import com.sstark97.user_signup_spring.domain.model.UserSignUp;
import com.sstark97.user_signup_spring.domain.repositories.UserSignUpRepository;
import io.vavr.control.Either;

public class UserSignUpService {
    private final UserSignUpRepository repository;

    public UserSignUpService(UserSignUpRepository repository) {
        this.repository = repository;
    }

    public Either<ApiError, String> save(UserSignUp user) {
        System.out.println("dfdsfdsfdsf");
        return repository.save(user);
    }
}
