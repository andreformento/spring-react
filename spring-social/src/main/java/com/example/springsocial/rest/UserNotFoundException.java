package com.example.springsocial.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private final UUID userId;

    public UserNotFoundException(UUID userId) {
        super(String.format("User not found with id : '%s'", userId.toString()));
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }

}
