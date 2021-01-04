package com.example.springsocial.auth;

import com.example.springsocial.auth.security.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedUserService {

    public LoggedUser getLoggedUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return new LoggedUser(userPrincipal);
    }

}
