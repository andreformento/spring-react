package com.example.springsocial.auth;

import com.example.springsocial.auth.security.UserPrincipal;
import com.example.springsocial.rest.UserNotFoundException;
import com.example.springsocial.user.User;
import com.example.springsocial.user.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LoggedUserService {

    private final UserRepository userRepository;

    public LoggedUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoggedUser getLoggedUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        final User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new UserNotFoundException(userPrincipal.getId()));
        return new LoggedUser(user);
    }

}
