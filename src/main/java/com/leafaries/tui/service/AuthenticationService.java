package com.leafaries.tui.service;

import org.springframework.stereotype.Component;

@Component
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        // TODO: Implement authentication logic
        // Placeholder authentication logic
        return "user".equals(username) && "pass".equals(password);
    }
}
