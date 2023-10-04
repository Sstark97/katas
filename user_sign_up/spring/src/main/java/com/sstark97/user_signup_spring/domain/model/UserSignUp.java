package com.sstark97.user_signup_spring.domain.model;

import com.sstark97.user_signup_spring.infrastructure.dto.UserDto;
import io.vavr.control.Either;

public class UserSignUp {
    private final String name;
    private final String email;
    private final String password;

    private UserSignUp(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Either<String, UserSignUp> of(UserDto userDto) {
        Either<String, Name> name = Name.of(userDto.name());
        Either<String, Email> email = Email.of(userDto.email());
        Either<String, Password> password = Password.of(userDto.password());

        if (name.isLeft()) {
            return Either.left(name.getLeft());
        } else if (email.isLeft()) {
            return Either.left(email.getLeft());
        } else if (password.isLeft()) {
            return Either.left(password.getLeft());
        }

        return Either.right(new UserSignUp(userDto.name(), userDto.email(), userDto.password()));
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
