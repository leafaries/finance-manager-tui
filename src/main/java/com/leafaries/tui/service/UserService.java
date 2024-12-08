package com.leafaries.tui.service;

import com.leafaries.tui.model.UserLoginDto;
import com.leafaries.tui.model.UserRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private final WebClient webClient;

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
