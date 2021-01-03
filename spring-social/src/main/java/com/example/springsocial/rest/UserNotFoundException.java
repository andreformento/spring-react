package com.example.springsocial.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    private final Long userId;

    public UserNotFoundException(Long userId) {
        super(String.format("User not found with id : '%d'", userId));
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

}
