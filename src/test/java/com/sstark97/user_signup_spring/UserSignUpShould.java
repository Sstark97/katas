package com.sstark97.user_signup_spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sstark97.user_signup_spring.domain.UserSignUp;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserSignUpShould {

    @Autowired
    private MockMvc mockMvc;

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
}
