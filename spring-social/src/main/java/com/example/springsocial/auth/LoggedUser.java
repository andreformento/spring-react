package com.example.springsocial.auth;

import com.example.springsocial.auth.rest.AuthProvider;
import com.example.springsocial.user.User;

public final class LoggedUser {
    private final Long id;
    private final String name;
    private final String email;
    private final String imageUrl;
    private final AuthProvider provider;

    public LoggedUser(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.imageUrl = user.getImageUrl();
        this.provider = user.getProvider();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AuthProvider getProvider() {
        return provider;
    }
}
