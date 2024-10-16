package com.leafaries.tui.service;

import java.util.List;

public class UserService {

    public List<String> getUsers() {
        // Normally, this would fetch data from a backend API
        // Here we're returning mock data for simplicity
        return List.of("Alice", "Bob", "Charlie");
    }
}
