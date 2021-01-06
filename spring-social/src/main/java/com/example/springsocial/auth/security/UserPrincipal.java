package com.example.springsocial.auth.security;

import com.example.springsocial.user.UserEntity;
import com.example.springsocial.workspace.Workspace;
import com.example.springsocial.workspace.WorkspaceEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.*;

public class UserPrincipal implements OAuth2User, UserDetails {
    private final UUID id;
    private final String name;
    private final String email;
    private final String password;
    private final String imageUrl;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Map<String, Object> attributes;
    private final Optional<Workspace> defaultWorkspace;

    public UserPrincipal(UUID id, String name, String email, String password, String imageUrl, Collection<? extends GrantedAuthority> authorities, Map<String, Object> attributes, Optional<Workspace> defaultWorkspace) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.imageUrl = imageUrl;
        this.authorities = authorities;
        this.attributes = attributes;
        this.defaultWorkspace = defaultWorkspace;
    }

    public static UserPrincipal create(UserEntity user, Map<String, Object> attributes) {
        List<GrantedAuthority> authorities = Collections.
                singletonList(new SimpleGrantedAuthority("ROLE_USER"));

        return new UserPrincipal(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getImageUrl(),
                authorities,
                attributes,
                user.getDefaultWorkspaceEntity().map(WorkspaceEntity::toModel)
        );
    }

    public static UserPrincipal create(UserEntity user) {
        return UserPrincipal.create(user, Collections.emptyMap());
    }

    public UUID getId() {
        return id;
    }

    public Optional<Workspace> getDefaultWorkspace() {
        return defaultWorkspace;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
