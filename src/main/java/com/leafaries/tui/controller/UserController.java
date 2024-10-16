package com.leafaries.tui.controller;

import com.leafaries.tui.view.UserView;
import com.leafaries.tui.service.UserService;

import java.util.List;

public class UserController {

    private final UserService userService;
    private final UserView userView;

    public UserController(UserService userService, UserView userView) {
        this.userService = userService;
        this.userView = userView;
    }

    public void showUsers() {
        // Fetch user data from the service
        List<String> users = userService.getUsers();

        // Display the users in the view
        userView.displayUsers(users);
    }
}
