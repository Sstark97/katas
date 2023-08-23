package com.sstark97.user_signup_spring;

public class UserSignUp {
    private final String name;
    private final String email;
    private final String password;

    public UserSignUp(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
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
