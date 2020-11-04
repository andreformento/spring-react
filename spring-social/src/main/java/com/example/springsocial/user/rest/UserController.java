package com.example.springsocial.user.rest;

import com.example.springsocial.auth.LoggedUser;
import com.example.springsocial.auth.LoggedUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final LoggedUserService loggedUserService;

    public UserController(LoggedUserService loggedUserService) {
        this.loggedUserService = loggedUserService;
    }

    @GetMapping("/me")
    @PreAuthorize("hasRole('USER')")
    public LoggedUser getCurrentUser() {
        return loggedUserService.getLoggedUser();
    }
}
