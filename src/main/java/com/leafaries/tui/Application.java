package com.leafaries.tui;

import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.leafaries.tui.controller.UserController;
import com.leafaries.tui.service.UserService;
import com.leafaries.tui.view.UserView;

public class Application {

    private final UserService userService;
    private final UserView userView;
    private final UserController userController;

    public Application(WindowBasedTextGUI gui) {
        // Initialize services and controllers
        this.userService = new UserService();
        this.userView = new UserView(gui);
        this.userController = new UserController(userService, userView);
    }

    public void run() {
        userController.showUsers();
    }
}
