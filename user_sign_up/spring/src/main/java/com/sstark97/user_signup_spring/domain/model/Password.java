package com.sstark97.user_signup_spring.domain.model;

import io.vavr.control.Either;
import java.util.Arrays;

public class Password {
    private static final int MINIMUM_LENGTH = 8;
    private final String password;

    private Password(String password) {
        this.password = password;
    }

    public static Either<String, Password> of(String password) {
        if(password.length() < MINIMUM_LENGTH) {
            return Either.left("The password must have 8 characters or more");
        } else if(notContainsAnyUpperCaseCharacter(password)) {
            return Either.left("The password must have 1 upper case or more");
        } else if (notContainsAnyDigit(password)) {
            return Either.left("The password must have 1 digit or more");
        } else if (notContainsSpecialCharacters(password)) {
            return Either.left("The password must have 1 special character or more");
        }
        return Either.right(new Password(password));
    }

    private static boolean notContainsSpecialCharacters(String password) {
        return Arrays.stream(password.split("")).filter(pass -> pass.matches("[-/@#!*$%^&.'_+={}()]+")).toList().isEmpty();
    }

    private static boolean notContainsAnyDigit(String password) {
        return password.chars().noneMatch(Character::isDigit);
    }

    private static boolean notContainsAnyUpperCaseCharacter(String password) {
        return password.chars().noneMatch(Character::isUpperCase);
    }

    public String getPassword() {
        return password;
    }
}
