package com.sstark97.user_signup_spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sstark97.user_signup_spring.domain.model.ApiError;
import com.sstark97.user_signup_spring.domain.repositories.UserSignUpRepository;
import com.sstark97.user_signup_spring.infrastructure.dto.UserDto;
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

    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void return_200_when_sign_up() throws Exception {
        UserDto user = new UserDto("name", "email@email.com", "@Passw0rd");
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
        UserDto user = new UserDto("name", "badFormatEmail", "@Passw0rd");
        String userToJson = mapper.writeValueAsString(user);
        ApiError emailWithBadFormat = new ApiError("The email have a bad format", HttpStatus.BAD_REQUEST);

        Mockito.when(repository.save(user)).thenReturn(Either.left(emailWithBadFormat));

        MvcResult request = mockMvc.perform(
                        post("/user/sign_up")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(userToJson)
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(request.getResponse().getContentAsString()).isEqualTo(emailWithBadFormat.getMessage());
    }

    @Test
    void return_400_when_sign_up_and_email_already_exists() throws Exception {
        UserDto user = new UserDto("name", "email@email.com", "@Passw0rd");
        String userToJson = mapper.writeValueAsString(user);
        ApiError theseEmailAlreadyExist = new ApiError("These email already exist", HttpStatus.BAD_REQUEST);

        Mockito.when(repository.save(user)).thenReturn(Either.left(theseEmailAlreadyExist));

        MvcResult request = mockMvc.perform(
                        post("/user/sign_up")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(userToJson)
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(request.getResponse().getContentAsString()).isEqualTo(theseEmailAlreadyExist.getMessage());
    }

    @Test
    void return_400_when_name_not_have_the_correct_length() throws Exception {
        UserDto user = new UserDto("na", "email@email.com", "@Passw0rd");
        String userToJson = mapper.writeValueAsString(user);
        ApiError nameWithIncorrectLength = new ApiError("The name must have 3 characters or more", HttpStatus.BAD_REQUEST);

        Mockito.when(repository.save(user)).thenReturn(Either.left(nameWithIncorrectLength));

        MvcResult request = mockMvc.perform(
                        post("/user/sign_up")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(userToJson)
                )
                .andExpect(status().isBadRequest())
                .andReturn();
        System.out.println(request.getResponse().getContentAsString());

        assertThat(request.getResponse().getContentAsString()).isEqualTo(nameWithIncorrectLength.getMessage());
    }

    @Test
    void return_400_when_password_not_have_the_correct_length() throws Exception {
        UserDto user = new UserDto("name", "email@email.com", "");
        String userToJson = mapper.writeValueAsString(user);
        ApiError passwordWithIncorrectLength = new ApiError("The password must have 8 characters or more", HttpStatus.BAD_REQUEST);

        Mockito.when(repository.save(user)).thenReturn(Either.left(passwordWithIncorrectLength));

        MvcResult request = mockMvc.perform(
                        post("/user/sign_up")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(userToJson)
                )
                .andExpect(status().isBadRequest())
                .andReturn();

        assertThat(request.getResponse().getContentAsString()).isEqualTo(passwordWithIncorrectLength.getMessage());
    }
}
