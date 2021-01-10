package com.example.springsocial.auth;

import com.example.springsocial.auth.security.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class LoggedUserService {

    @RequestScope
    @Bean
    public LoggedUser createLoggedUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return new LoggedUser(userPrincipal);
    }

}
