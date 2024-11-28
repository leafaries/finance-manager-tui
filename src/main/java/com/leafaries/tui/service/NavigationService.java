package com.leafaries.tui.service;

import com.leafaries.tui.controller.LoginController;
import com.leafaries.tui.view.RegistrationView;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class NavigationService {
    private final ApplicationContext applicationContext;

    public NavigationService(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void navigateToRegistrationView() {
        RegistrationView registrationView = applicationContext.getBean(RegistrationView.class);
        registrationView.display();
    }

    public void login(String username, String password) {
        LoginController loginController = applicationContext.getBean(LoginController.class);
        loginController.handleLogin(username, password);
    }
}
