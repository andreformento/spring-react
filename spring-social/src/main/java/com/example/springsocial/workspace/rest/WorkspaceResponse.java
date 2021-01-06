package com.example.springsocial.workspace.rest;

import com.example.springsocial.auth.LoggedUser;
import com.example.springsocial.workspace.Workspace;

import java.util.UUID;

class WorkspaceResponse {

    private final Workspace workspace;
    private final Boolean isDefault;

    private WorkspaceResponse(Workspace workspace, Boolean isDefault) {
        this.workspace = workspace;
        this.isDefault = isDefault;
    }

    static WorkspaceResponse fromModelOfCurrentUser(Workspace workspace, LoggedUser loggedUser) {
        final Boolean isDefault = loggedUser.getDefaultWorkspace().map(w -> w.equals(workspace)).orElse(false);
        return new WorkspaceResponse(workspace, isDefault);
    }

    public UUID getId() {
        return workspace.getId();
    }

    public String getName() {
        return workspace.getName();
    }

    public Boolean isDefault() {
        return isDefault;
    }

}
