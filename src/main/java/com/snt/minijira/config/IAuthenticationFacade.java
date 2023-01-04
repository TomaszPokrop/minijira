package com.snt.minijira.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

public interface IAuthenticationFacade {
    Authentication getAuthentication();
    public String getName();
    public UserDetails getUserDetails();
    @Component
    public class AuthenticationFacade implements IAuthenticationFacade{

        @Override
        public Authentication getAuthentication() {
            return SecurityContextHolder.getContext().getAuthentication();
        }

        @Override
        public String getName() {
            return getAuthentication().getName();
        }

        @Override
        public UserDetails getUserDetails() {
            return (UserDetails) getAuthentication().getPrincipal();
        }
    }
}
