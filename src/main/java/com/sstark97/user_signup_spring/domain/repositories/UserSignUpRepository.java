package com.sstark97.user_signup_spring.domain.repositories;

import com.sstark97.user_signup_spring.domain.model.UserSignUp;

public interface UserSignUpRepository {
    void save(UserSignUp user);
}
