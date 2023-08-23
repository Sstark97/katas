package com.sstark97.user_signup_spring.domain.model;

import io.vavr.control.Either;

public class Email {
    private final String email;

    private Email(String email) {
        this.email = email;
    }

    public static Either<String, Email> of(String email) {
        if(notHaveTheCorrectFormat(email)) {
            return Either.left("The email have a bad format");
        }
        return Either.right(new Email(email));
    }

    private static boolean notHaveTheCorrectFormat(String email) {
        return !email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
