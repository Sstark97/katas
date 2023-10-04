package com.sstark97.user_signup_spring.domain.model;

import org.springframework.http.HttpStatus;

public class ApiError {
    private final String message;
    private final HttpStatus statusCode;

    public ApiError(String message, HttpStatus statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
