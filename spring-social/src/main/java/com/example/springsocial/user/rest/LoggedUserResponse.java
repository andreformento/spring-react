package com.example.springsocial.user.rest;

import com.example.springsocial.auth.LoggedUser;
import com.example.springsocial.workspace.Workspace;

import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

class LoggedUserResponse implements Serializable {

    private final LoggedUser loggedUser;

    static class WorkspaceDTO {
        private final Workspace workspace;

        private WorkspaceDTO(Workspace workspace) {
            this.workspace = workspace;
        }

        public UUID getId() {
            return workspace.getId();
        }

        public String getName() {
            return workspace.getName();
        }
    }

    LoggedUserResponse(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    public UUID getId() {
        return loggedUser.getId();
    }
    public String getName() {
        return loggedUser.getName();
    }
    public String getEmail() {
        return loggedUser.getEmail();
    }
    public String getImageUrl() {
        return loggedUser.getImageUrl();
    }
    public Optional<WorkspaceDTO> getDefaultWorkspace() {
        return loggedUser.getDefaultWorkspace().map(WorkspaceDTO::new);
    }

}
