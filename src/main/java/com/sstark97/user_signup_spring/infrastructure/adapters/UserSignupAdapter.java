package com.sstark97.user_signup_spring.infrastructure.adapters;

import com.sstark97.user_signup_spring.domain.model.ApiError;
import com.sstark97.user_signup_spring.domain.model.UserSignUp;
import com.sstark97.user_signup_spring.domain.repositories.UserSignUpRepository;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserSignupAdapter implements UserSignUpRepository {
    @Override
    public Either<ApiError, String> save(UserSignUp user) {
        return Either.left(new ApiError("The email have a bad format", HttpStatus.BAD_REQUEST));
    }
}
