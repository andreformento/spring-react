package com.example.springsocial.user.rest;

import com.example.springsocial.auth.LoggedUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final LoggedUser loggedUser;

    public UserController(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }


    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public LoggedUserResponse getCurrentUser() {
        return new LoggedUserResponse(loggedUser);
    }
}
