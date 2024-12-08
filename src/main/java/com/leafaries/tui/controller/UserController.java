package com.leafaries.tui.controller;

import com.leafaries.tui.service.UserService;
import com.leafaries.tui.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@AllArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final UserView userView;

    public void showUsers() {
        List<String> users = userService.getUsers();
//        userView.displayUsers(users);
    }

}
