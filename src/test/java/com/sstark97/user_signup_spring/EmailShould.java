package com.sstark97.user_signup_spring;

import com.sstark97.user_signup_spring.domain.model.Email;
import org.junit.jupiter.api.Test;
import io.vavr.control.Either;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class EmailShould {
    @Test
    void get_an_error_message_with_a_bad_email_format() {
        Either<String, Email> email = Email.of("bademail");

        assertThat(email.isLeft()).isTrue();
        assertThat(email.getLeft()).isEqualTo("The email have a bad format");
    }

    @Test
    void get_an_email_with_a_good_email_format() {
        Either<String, Email> email = Email.of("good@email.com");

        assertThat(email.isRight()).isTrue();
    }
}
