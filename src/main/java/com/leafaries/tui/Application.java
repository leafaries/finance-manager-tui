package com.leafaries.tui;

import com.leafaries.tui.controller.LoginController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private final LoginController loginController;

    // TODO: Import more (all) controllers to controll the flow of the entire app from this class
    public Application(LoginController loginController) {
        this.loginController = loginController;
    }

    public void run() {
        logger.info("Starting application");
        loginController.run();
        logger.info("Ending application");
    }
}
