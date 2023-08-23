package com.sstark97.user_signup_spring.infrastructure.configuration;

import com.sstark97.user_signup_spring.application.services.UserSignUpService;
import com.sstark97.user_signup_spring.domain.repositories.UserSignUpRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.sstark97.user_signup_spring")
public class BeanConfiguration {
    @Bean
    UserSignUpService productService(final UserSignUpRepository userSignUpRepository) {
        return new UserSignUpService(userSignUpRepository);
    }
}