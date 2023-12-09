package com.javaev.usermanagement.service;

import com.javaev.usermanagement.model.User; 
import com.javaev.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository; // type and variable
    private final PasswordEncoder passwordEncoder; // Final means that the value of the variable cannot change

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) { // the constructor expect to receive an object of type UserRepo when UserService is instanciated
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) { // method bring back an object type User, registerUser is the method, User user is the parameter that recieves.
        // Verify if the email is already register
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exist");
        }

        String encodedPassword = passwordEncoder.encode(user.getPassword()); //local variable inside the method
        user.setPassword(encodedPassword);

        // Save User
        return userRepository.save(user);
    }
}
