/*package com.javaev.usermanagement.userservicetest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.javaev.usermanagement.model.User;
import com.javaev.usermanagement.repository.UserRepository;
import com.javaev.usermanagement.security.JwtUtil;
import com.javaev.usermanagement.service.UserService;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    
    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        // UUID as Id
        when(userRepository.findByEmail(anyString()))
                .thenReturn(Optional.empty());
        when(passwordEncoder.encode(anyString())).thenReturn("encryptedPassword");
        when(jwtUtil.generateToken(anyString())).thenReturn("dummyToken");
    }

    @Test
    public void whenRegisterUser_thenSuccess() {
        // given
        User user = new User();
        user.setName("Test User");
        user.setEmail("test@example.com");
        // ... set other user properties

        // when
        User savedUser = userService.registerUser(user);

        // then
        assertNotNull(savedUser);
        verify(userRepository).save(user);
        assertEquals("dummyToken", savedUser.getToken());
    }

    @Test
    public void whenRegisterUserWithExistingEmail_thenThrowException() {
        // given
        User user = new User();
        user.setEmail("test@example.com");
        // when existing email is found
        when(userRepository.findByEmail(user.getEmail()))
                .thenReturn(Optional.of(user));

        // then
        assertThrows(RuntimeException.class, () -> {
            userService.registerUser(user);
        });
    }
}
*/