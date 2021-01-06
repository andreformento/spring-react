package com.example.springsocial.auth.security;


import com.example.springsocial.rest.UserNotFoundException;
import com.example.springsocial.user.UserEntity;
import com.example.springsocial.user.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final Users users;

    public CustomUserDetailsService(Users users) {
        this.users = users;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        UserEntity user = users.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email : " + email)
        );

        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(UUID id) {
        UserEntity user = users.findById(id).orElseThrow(
            () -> new UserNotFoundException(id)
        );

        return UserPrincipal.create(user);
    }
}
