package com.example.springsocial.user;

import com.example.springsocial.workspace.Workspace;

import java.util.Optional;
import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;
    private final Optional<Workspace> defaultWorkspace;

    public User(UUID id, String name, Optional<Workspace> defaultWorkspace) {
        this.id = id;
        this.name = name;
        this.defaultWorkspace = defaultWorkspace;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<Workspace> getDefaultWorkspace() {
        return defaultWorkspace;
    }
}
