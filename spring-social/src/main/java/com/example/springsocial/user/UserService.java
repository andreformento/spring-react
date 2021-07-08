package com.example.springsocial.user;

import com.example.springsocial.workspace.Workspace;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final Users users;

    public UserService(Users users) {
        this.users = users;
    }

    public void setDefaultWorkspace(Workspace workspace, User user) {
        users.setUserDefaultWorkspaceById(workspace.getId(), user.getId());
    }

}
