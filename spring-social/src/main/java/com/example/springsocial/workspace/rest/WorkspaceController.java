package com.example.springsocial.workspace.rest;

import com.example.springsocial.auth.LoggedUser;
import com.example.springsocial.auth.LoggedUserService;
import com.example.springsocial.user.UserEntity;
import com.example.springsocial.workspace.WorkspaceEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/workspaces")
public class WorkspaceController {
    private final WorkspaceService workspaceService;
    private final LoggedUser loggedUser;

    public WorkspaceController(WorkspaceService workspaceService, LoggedUser loggedUser) {
        this.workspaceService = workspaceService;
        this.loggedUser = loggedUser;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<WorkspaceResponse> getWorkspaces() {
        return workspaceService
                .getWorkspaces()
                .stream()
                .map(w -> WorkspaceResponse.fromModelOfCurrentUser(w, loggedUser))
                .collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public WorkspaceResponse createWorkspace(@RequestBody NewWorkspace newWorkspace) {
        return new WorkspaceResponse(workspaceService.createWorkspace(newWorkspace), true);
    }

}
