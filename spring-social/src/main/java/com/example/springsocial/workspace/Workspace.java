package com.example.springsocial.workspace;

import java.util.Objects;
import java.util.UUID;

public class Workspace {

    private final UUID id;
    private final String name;

    Workspace(WorkspaceEntity workspaceEntity) {
        this.id = workspaceEntity.getId();
        this.name = workspaceEntity.getName();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workspace workspace = (Workspace) o;
        return Objects.equals(id, workspace.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
