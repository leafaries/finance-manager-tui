package com.leafaries.tui;

import com.leafaries.tui.controller.LoginController;
import com.leafaries.tui.controller.UserController;
import com.leafaries.tui.exceptions.ScreenInitializationException;
import com.leafaries.tui.service.NavigationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Application {
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    private final NavigationService navigationService;

    // TODO: Import more (all) controllers to controll the flow of the entire app from this class
    public Application(NavigationService navigationService) {
        this.navigationService = navigationService;
    }

    public void run() {
        LOGGER.info("Starting application");
        navigationService.login();
        LOGGER.info("Ending application");
    }
}
