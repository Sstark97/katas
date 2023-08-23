package com.sstark97.user_signup_spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class UserSignUpShould {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void return_200_when_sign_up() throws Exception {
        mockMvc.perform(post("/user"))
                .andExpect(status().isOk());
    }
}
