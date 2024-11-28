package com.leafaries.tui.controller;

import com.leafaries.tui.service.AuthenticationService;
import com.leafaries.tui.view.LoginView;
import com.leafaries.tui.view.MainMenuView;
import com.leafaries.tui.view.RegistrationView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final LoginView loginView;
    private final MainMenuView mainMenuView;
    private final RegistrationView registrationView;
    private final AuthenticationService authenticationService;

    public LoginController(LoginView loginView,
                           RegistrationView registrationView,
                           MainMenuView mainMenuView,
                           AuthenticationService authenticationService) {
        this.loginView = loginView;
        this.registrationView = registrationView;
        this.mainMenuView = mainMenuView;
        this.authenticationService = authenticationService;
    }

    public void run() {
        logger.info("Starting login controller");
        loginView.setHandleLoginButtonPress(() -> handleLogin(loginView.getUsername(), loginView.getPassword()));
        loginView.setNavigateToRegistrationButtonPress(this::navigateToRegistrationView);
        loginView.display();
    }

    public void handleLogin(String username, String password) {
        logger.info("Login attempt with username: {}", username);
        if (authenticationService.authenticate(username, password)) {
            logger.info("Authentication successful for username: {}", username);
            loginView.showMessage("Successfully logged in!");
            mainMenuView.display();
        } else {
            logger.warn("Authentication failed for username: {}", username);
            loginView.showMessage("Username or password is incorrect. Please try again.");
            loginView.display();
        }
    }

    public void navigateToRegistrationView() {
        logger.info("Navigating to registration view");
        registrationView.display();
    }
}
