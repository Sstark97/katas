package com.sstark97.user_signup_spring.domain.model;

import com.sstark97.user_signup_spring.infrastructure.dto.UserDto;
import io.vavr.control.Either;

public class UserSignUp {
    private final String name;
    private final Email email;
    private final String password;

    private UserSignUp(String name, Email email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Either<String, UserSignUp> of(UserDto userDto) {
        Either<String, Email> email = Email.of(userDto.email());
        if (email.isLeft()) {
            return Either.left(email.getLeft());
        }

        return Either.right(new UserSignUp(userDto.name(), email.get(), userDto.password()));
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
