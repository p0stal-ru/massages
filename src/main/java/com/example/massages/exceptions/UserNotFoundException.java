package com.example.massages.exceptions;

/**
 * @author EduardYatskovskiy
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("User with id " + userId + " was not found");
    }
}
