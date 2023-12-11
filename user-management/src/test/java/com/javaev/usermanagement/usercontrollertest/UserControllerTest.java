package com.javaev.usermanagement.usercontrollertest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaev.usermanagement.controller.UserController;
import com.javaev.usermanagement.model.User;
import com.javaev.usermanagement.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void whenRegisterUser_thenReturnUser() throws Exception {
        // given
        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");


        when(userService.registerUser(any(User.class))).thenReturn(user);

        // when // then
        mockMvc.perform(post("/api/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value(user.getEmail()));
    }
}
