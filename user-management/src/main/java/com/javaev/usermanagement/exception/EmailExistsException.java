package com.javaev.usermanagement.exception;

public class EmailExistsException extends RuntimeException {
    
    public EmailExistsException(String message) {
        super(message); 
    }
}
