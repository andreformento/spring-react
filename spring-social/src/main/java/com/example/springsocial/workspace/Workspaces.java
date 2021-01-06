package com.example.springsocial.workspace;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface Workspaces extends JpaRepository<WorkspaceEntity, UUID> {

    List<WorkspaceEntity> findByOwnerId(UUID owner);

}
