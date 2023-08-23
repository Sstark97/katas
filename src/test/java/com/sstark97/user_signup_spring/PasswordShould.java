package com.sstark97.user_signup_spring;

import com.sstark97.user_signup_spring.domain.model.Password;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class PasswordShould {
    @Test
    void get_an_error_message_with_a_password_of_3_characters_or_less() {
        Either<String, Password> email = Password.of("na");

        assertThat(email.isLeft()).isTrue();
        assertThat(email.getLeft()).isEqualTo("The name must have 3 characters or more");
    }
}
