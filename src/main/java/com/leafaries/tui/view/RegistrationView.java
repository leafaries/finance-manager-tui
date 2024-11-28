package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RegistrationView {
    private static final Logger logger = LoggerFactory.getLogger(RegistrationView.class);

    private final WindowBasedTextGUI gui;

    public RegistrationView(WindowBasedTextGUI gui) {
        this.gui = gui;
    }

    public void display() {
        logger.info("Displaying RegistrationView");

        BasicWindow window = new BasicWindow("User Registration");
        Panel registerPanel = new Panel(new GridLayout(2));

        registerPanel.addComponent(new Label("Username:"));
        TextBox usernameField = new TextBox();
        registerPanel.addComponent(usernameField);

        registerPanel.addComponent(new Label("password:"));
        TextBox passwordField = new TextBox().setMask('*');
        registerPanel.addComponent(passwordField);

        registerPanel.addComponent(new Button("Register", () -> {
            logger.info("Register button pressed");
            // TODO: Implement backend API call to register a user
            window.close();
            logger.info("Closed the registration window");
        }));

        window.setComponent(registerPanel);
        gui.addWindowAndWait(window);
    }
}
