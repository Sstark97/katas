package com.sstark97.user_signup_spring.domain.repositories;

import com.sstark97.user_signup_spring.domain.model.ApiError;
import com.sstark97.user_signup_spring.domain.model.UserSignUp;
import io.vavr.control.Either;

public interface UserSignUpRepository {
    Either<ApiError, String> save(UserSignUp user);
}
