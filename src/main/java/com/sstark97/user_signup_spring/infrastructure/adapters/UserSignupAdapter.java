package com.sstark97.user_signup_spring.infrastructure.adapters;

import com.sstark97.user_signup_spring.domain.model.ApiError;
import com.sstark97.user_signup_spring.domain.model.UserSignUp;
import com.sstark97.user_signup_spring.domain.repositories.UserSignUpRepository;
import com.sstark97.user_signup_spring.infrastructure.dto.UserDto;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserSignupAdapter implements UserSignUpRepository {
    public static final String EMAIL_ALREADY_EXIST_ERROR = "These email already exist";

    @Override
    public Either<ApiError, String> save(UserDto userDto) {
        Either<String, UserSignUp> user = UserSignUp.of(userDto);
        String name = userDto.name();
        if(name.length() < 3) {
            return Either.left(new ApiError("The name must have 3 characters or more", HttpStatus.BAD_REQUEST));
        }
        if(user.isLeft()) {
            return Either.left(new ApiError(user.getLeft(), HttpStatus.BAD_REQUEST));
        }
        return Either.left(new ApiError(EMAIL_ALREADY_EXIST_ERROR, HttpStatus.BAD_REQUEST));
    }
}
