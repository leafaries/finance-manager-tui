package com.leafaries.tui.controller;

import com.leafaries.tui.service.AuthenticationService;
import com.leafaries.tui.service.NavigationService;
import com.leafaries.tui.view.LoginView;
import com.leafaries.tui.view.MainMenuView;
import com.leafaries.tui.view.RegistrationView;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {
    private final AuthenticationService authenticationService;
    private final NavigationService navigationService;

//    private final LoginView loginView;
//    private final MainMenuView mainMenuView;
//    private final RegistrationView registrationView;

    public LoginController(NavigationService navigationService) {
        this.authenticationService = authenticationService;
        this.navigationService = navigationService;

//        this.loginView = loginView;
//        this.mainMenuView = mainMenuView;
//        this.registrationView = registrationView;
    }

    public void displayLoginView() {
        loginView.display();
    }

    public void handleLogin(String username, String password) {
        if (authenticationService.authenticate(username, password)) {
            loginView.showMessage("Successfully logged in!");
            mainMenuView.display();
        } else {
            loginView.showMessage("Username or password is incorrect. Please try again.");
            loginView.display();
        }
    }

    public void navigateToRegistrationView() {
        registrationView.display();
    }
}
