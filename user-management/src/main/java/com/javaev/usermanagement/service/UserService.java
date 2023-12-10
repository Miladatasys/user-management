package com.javaev.usermanagement.service;

import com.javaev.usermanagement.model.User; 
import com.javaev.usermanagement.repository.UserRepository;
import com.javaev.usermanagement.security.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // Método para registrar usuarios
    public User registerUser(User user) {
        // Verificar si el correo electrónico ya está registrado
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        // Encriptar la contraseña y guardar el usuario
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Suponiendo que tienes un método en User para establecer el token JWT
        user.setToken(jwtUtil.generateToken(user.getName()));

        return userRepository.save(user);
    }
}
