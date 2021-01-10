package com.example.springsocial.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface Users extends JpaRepository<UserEntity, UUID> {

    Optional<UserEntity> findByEmail(String email);

    Boolean existsByEmail(String email);

    @Modifying
    @Query("update UserEntity u set u.defaultWorkspace = ?1 where u.id = ?2")
    void setUserDefaultWorkspaceById(UUID workspaceId, UUID userId);

}
