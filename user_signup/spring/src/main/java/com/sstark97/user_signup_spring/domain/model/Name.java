package com.sstark97.user_signup_spring.domain.model;

import io.vavr.control.Either;

public class Name {
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Either<String, Name> of(String name) {
        if(name.length() < 3) {
            return Either.left("The name must have 3 characters or more");
        }
        return Either.right(new Name(name));
    }

    public String getName() {
        return name;
    }
}
