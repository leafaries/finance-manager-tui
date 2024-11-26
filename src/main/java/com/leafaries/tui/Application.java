package com.leafaries.tui;

import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.leafaries.tui.controller.UserController;
import com.leafaries.tui.service.UserService;
import com.leafaries.tui.view.MainMenuView;
import com.leafaries.tui.view.UserView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private final UserController userController;
    private final MainMenuView mainMenuView;

    // Dependency injection
    public Application(WindowBasedTextGUI gui) {
        UserService userService = new UserService();
        UserView userView = new UserView(gui);
        this.userController = new UserController(userService, userView);

        this.mainMenuView = new MainMenuView(gui);
    }

    public void run() {
        userController.showUsers();
    }
}
