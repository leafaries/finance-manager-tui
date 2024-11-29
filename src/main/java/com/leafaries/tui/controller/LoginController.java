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
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

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
        log.info("Starting login controller");
        loginView.setHandleLoginButtonPress(() -> handleLogin(loginView.getUsername(), loginView.getPassword()));
        loginView.setNavigateToRegistrationButtonPress(this::navigateToRegistrationView);
        registrationView.setNavigateToLoginButtonPress(this::navigateToLoginView);
        navigateToLoginView();
    }

    public void handleLogin(String username, String password) {
        log.info("Login attempt with username: {}", username);
        if (authenticationService.authenticate(username, password)) {
            log.info("Authentication successful for username: {}", username);
            loginView.showMessage("Successfully logged in!");

            loginView.close();
            log.info("Closed LoginView window after successful login");

            mainMenuView.display();
        } else {
            log.warn("Authentication failed for username: {}", username);
            loginView.showMessage("Username or password is incorrect. Please try again.");
            loginView.display();
        }
    }

    public void navigateToRegistrationView() {
        log.info("Navigating to RegistrationView");
        loginView.close();
        log.info("Closed LoginView window before navigating to RegistrationView");
        registrationView.display();
        log.info("Finished navigation to RegistrationView");
    }

    public void navigateToLoginView() {
        log.info("Navigating to LoginView");
        registrationView.close();
        log.info("Closed RegistrationView window before navigating to LoginView");
        loginView.display();
        log.info("Finished navigation to LoginView");
    }
}
