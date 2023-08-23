package com.sstark97.user_signup_spring.infrastructure.adapters;

import com.sstark97.user_signup_spring.domain.model.ApiError;
import com.sstark97.user_signup_spring.domain.model.Email;
import com.sstark97.user_signup_spring.domain.model.UserSignUp;
import com.sstark97.user_signup_spring.domain.repositories.UserSignUpRepository;
import com.sstark97.user_signup_spring.infrastructure.dto.UserDto;
import io.vavr.control.Either;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserSignupAdapter implements UserSignUpRepository {

    public static final String BAD_FORMAT_ERROR = "The email have a bad format";
    public static final String EMAIL_ALREADY_EXIST_ERROR = "These email already exist";

    @Override
    public Either<ApiError, String> save(UserDto userDto) {
        Either<String, UserSignUp> user = UserSignUp.of(userDto);
        if(user.isLeft()) {
            return Either.left(new ApiError(user.getLeft(), HttpStatus.BAD_REQUEST));
        }
        return Either.left(new ApiError(EMAIL_ALREADY_EXIST_ERROR, HttpStatus.BAD_REQUEST));
    }
}
