package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RegistrationView {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationView.class);

    private final WindowBasedTextGUI gui;
    private final BasicWindow window;
    private TextBox usernameField;
    private TextBox passwordField;
    private Runnable navigateToLoginButtonPress;

    public RegistrationView(WindowBasedTextGUI gui) {
        this.gui = gui;
        window = new BasicWindow("User Registration");
    }

    private void initializeComponents() {
        logger.debug("Initializing RegistrationView components");
        Panel registerPanel = new Panel(new GridLayout(2));

        registerPanel.addComponent(new Label("Username:"));
        usernameField = new TextBox();
        registerPanel.addComponent(usernameField);
        registerPanel.addComponent(new Label("Password:"));
        passwordField = new TextBox().setMask('*');
        registerPanel.addComponent(passwordField);
        registerPanel.addComponent(new Button("Register", this::navigateToLoginView));

        window.setComponent(registerPanel);
        logger.debug("RegistrationView components initialized");
    }

    public void display() {
        logger.info("Displaying RegistrationView");
        initializeComponents();
        gui.addWindowAndWait(window);
        logger.info("Closed the RegistrationView");
    }

    private void navigateToLoginView() {
        if (navigateToLoginButtonPress != null) {
            logger.info("Navigating to RegistrationView");
            navigateToLoginButtonPress.run();
        } else {
            logger.warn("Navigate to login button press handler is not set");
        }
    }

    public void setNavigateToLoginButtonPress(Runnable navigateToLoginButtonPress) {
        this.navigateToLoginButtonPress = navigateToLoginButtonPress;
    }

    public void close() {
        window.close();
        logger.info("RegistrationView window closed");
    }
}
