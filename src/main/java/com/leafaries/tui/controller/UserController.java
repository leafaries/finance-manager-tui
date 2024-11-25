package com.leafaries.tui.controller;

import com.leafaries.tui.service.UserService;
import com.leafaries.tui.view.UserView;

import java.util.List;

public class UserController {
    private final UserService userService;
    private final UserView userView;

    public UserController(UserService userService, UserView userView) {
        this.userService = userService;
        this.userView = userView;
    }

    public void showUsers() {
        List<String> users = userService.getUsers();

        userView.displayUsers(users);
    }
}
