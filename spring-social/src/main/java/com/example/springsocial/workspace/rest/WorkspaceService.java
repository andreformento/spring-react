package com.example.springsocial.workspace.rest;

import com.example.springsocial.auth.LoggedUser;
import com.example.springsocial.user.UserEntity;
import com.example.springsocial.user.UserService;
import com.example.springsocial.workspace.Workspace;
import com.example.springsocial.workspace.WorkspaceEntity;
import com.example.springsocial.workspace.Workspaces;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkspaceService {
    private final Workspaces workspaces;
    private final LoggedUser loggedUser;
    private final UserService userService;

    public WorkspaceService(Workspaces workspaces, LoggedUser loggedUser, UserService userService) {
        this.workspaces = workspaces;
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    public List<Workspace> getWorkspaces() {
        return workspaces
                .findByOwnerId(loggedUser.getId())
                .stream()
                .map(WorkspaceEntity::toModel)
                .collect(Collectors.toList());
    }

    public Workspace createWorkspace(NewWorkspace newWorkspace) {
        WorkspaceEntity workspaceEntity = new WorkspaceEntity();
        workspaceEntity.setName(newWorkspace.getName());
        UserEntity userEntity = new UserEntity();
        userEntity.setId(loggedUser.getId());
        workspaceEntity.setOwner(userEntity);
        WorkspaceEntity createdWorkspaceEntity = workspaces.save(workspaceEntity);
        Workspace workspace = createdWorkspaceEntity.toModel();
        userService.setDefaultWorkspace(workspace, loggedUser.toModel());
        return workspace;
    }

}
