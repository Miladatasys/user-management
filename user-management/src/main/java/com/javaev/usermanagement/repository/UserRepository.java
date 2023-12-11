package com.javaev.usermanagement.repository;

import com.javaev.usermanagement.model.User;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> { 
    Optional<User> findByEmail(String email);

    List<User> findByIsActive(Boolean isActive);

    List<User> findByCreatedAfter(Date date);

    List<User> findByName(String name);

} 

