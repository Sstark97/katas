package com.sstark97.user_signup_spring.domain.model;

import io.vavr.control.Either;

public class Password {
    private String password;

    private Password(String password) {
        this.password = password;
    }

    public static Either<String, Password> of(String password) {
        if(password.length() < 8) {
            return Either.left("The password must have 8 characters or more");
        }
        return Either.right(new Password(password));
    }
}
