package com.javaev.usermanagement.repository;

import com.javaev.usermanagement.model.Phone; 
import org.springframework.data.jpa.repository.JpaRepository; 

public interface PhoneRepository extends JpaRepository<Phone, Long> {

} 