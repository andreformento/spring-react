package com.example.springsocial.auth;

import com.example.springsocial.auth.security.UserPrincipal;

public final class LoggedUser {
    private final Long id;
    private final String name;
    private final String email;
    private final String imageUrl;

    public LoggedUser(UserPrincipal userPrincipal) {
        this.id = userPrincipal.getId();
        this.name = userPrincipal.getName();
        this.email = userPrincipal.getEmail();
        this.imageUrl = userPrincipal.getImageUrl();
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

}
