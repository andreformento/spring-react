package com.example.springsocial.auth;

import com.example.springsocial.auth.security.UserPrincipal;
import com.example.springsocial.workspace.Workspace;

import java.util.Optional;
import java.util.UUID;

public final class LoggedUser {
    private final UUID id;
    private final String name;
    private final String email;
    private final String imageUrl;
    private final Optional<Workspace> defaultWorkspace;

    public LoggedUser(UserPrincipal userPrincipal) {
        this.id = userPrincipal.getId();
        this.name = userPrincipal.getName();
        this.email = userPrincipal.getEmail();
        this.imageUrl = userPrincipal.getImageUrl();
        this.defaultWorkspace = userPrincipal.getDefaultWorkspace();
    }

    public UUID getId() {
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

    public Optional<Workspace> getDefaultWorkspace() {
        return defaultWorkspace;
    }
}
