package com.sstark97.user_signup_spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sstark97.user_signup_spring.domain.model.ApiError;
import com.sstark97.user_signup_spring.domain.model.UserSignUp;
import com.sstark97.user_signup_spring.domain.repositories.UserSignUpRepository;
import io.vavr.control.Either;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserSignUpShould {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private UserSignUpRepository repository;

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    void return_200_when_sign_up() throws Exception {
        UserSignUp user = new UserSignUp("name", "email@email.com", "@Passw0rd");
        String userToJson = mapper.writeValueAsString(user);

        mockMvc.perform(
                post("/user/sign_up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userToJson)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.equalTo("name")));
    }

    @Test
    void return_400_when_sign_up_with_a_bad_email_format() throws Exception {
        UserSignUp user = new UserSignUp("name", "badFormatEmail", "@Passw0rd");
        String userToJson = mapper.writeValueAsString(user);

        Mockito.when(repository.save(user)).thenReturn(Either.left(new ApiError("The email have a bad format", HttpStatus.BAD_REQUEST)));

        MvcResult request = mockMvc.perform(
                        post("/user/sign_up")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(userToJson)
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(request.getResponse().getContentAsString()).isEqualTo("The email have a bad format");
    }

    @Test
    void return_400_when_sign_up_and_email_already_exists() throws Exception {
        UserSignUp user = new UserSignUp("name", "badFormatEmail", "@Passw0rd");
        String userToJson = mapper.writeValueAsString(user);

        Mockito.when(repository.save(user)).thenReturn(Either.left(new ApiError("These email already exist", HttpStatus.BAD_REQUEST)));

        MvcResult request = mockMvc.perform(
                        post("/user/sign_up")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(userToJson)
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(request.getResponse().getContentAsString()).isEqualTo("These email already exist");
    }
}
