package com.example.springsocial.workspace.rest;

import com.example.springsocial.auth.LoggedUser;
import com.example.springsocial.auth.LoggedUserService;
import com.example.springsocial.workspace.Workspace;
import com.example.springsocial.workspace.WorkspaceEntity;
import com.example.springsocial.workspace.Workspaces;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/workspaces")
public class WorkspaceController {
    private final Workspaces workspaces;
    private final LoggedUserService loggedUserService;

    public WorkspaceController(Workspaces workspaces, LoggedUserService loggedUserService) {
        this.workspaces = workspaces;
        this.loggedUserService = loggedUserService;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<WorkspaceResponse> getWorkspaces() {
        final LoggedUser loggedUser = loggedUserService.getLoggedUser();
        return workspaces
                .findByOwnerId(loggedUser.getId())
                .stream()
                .map(WorkspaceEntity::toModel)
                .map(w -> WorkspaceResponse.fromModelOfCurrentUser(w, loggedUser))
                .collect(Collectors.toList());
    }
}
