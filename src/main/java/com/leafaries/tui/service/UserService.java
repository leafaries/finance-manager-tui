package com.leafaries.tui.service;

import com.leafaries.tui.model.UserLoginDto;
import com.leafaries.tui.model.UserRegistrationDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class UserService {
    private final WebClient webClient;

    public UserService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void register(UserRegistrationDto userRegistrationDto) {
        // TODO: Implement
    }

    public void login(UserLoginDto userLoginDto) {
        // TODO: Implement
    }

    public List<String> getUsers() {
        // TODO: Implement
        return null;
    }
}
