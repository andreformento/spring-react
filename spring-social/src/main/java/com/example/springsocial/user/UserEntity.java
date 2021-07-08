package com.example.springsocial.user;
import com.example.springsocial.auth.AuthProvider;
import com.example.springsocial.workspace.Workspace;
import com.example.springsocial.workspace.WorkspaceEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Email
    @Column(nullable = false)
    private String email;

    private String imageUrl;

    @Column(nullable = false)
    private Boolean emailVerified = false;

    @JsonIgnore
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    private String providerId;

    @OneToMany(mappedBy = "owner")
    private List<WorkspaceEntity> workspaces;

    @ManyToOne
    @JoinColumn(name="default_workspace_id")
    private WorkspaceEntity defaultWorkspace;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthProvider getProvider() {
        return provider;
    }

    public void setProvider(AuthProvider provider) {
        this.provider = provider;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public List<WorkspaceEntity> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<WorkspaceEntity> workspaces) {
        this.workspaces = workspaces;
    }

    public Optional<WorkspaceEntity> getDefaultWorkspaceEntity() {
        return Optional.ofNullable(defaultWorkspace);
    }

    public void setDefaultWorkspace(WorkspaceEntity defaultWorkspace) {
        this.defaultWorkspace = defaultWorkspace;
    }
}
