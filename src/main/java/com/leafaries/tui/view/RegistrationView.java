package com.leafaries.tui.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class RegistrationView {
    private static final TerminalSize TEXT_FIELD_SIZE = new TerminalSize(16, 1);

    private static final Logger log = LoggerFactory.getLogger(RegistrationView.class);

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
        log.debug("Initializing RegistrationView components");

        Panel registerPanel = new Panel(new GridLayout(2));
        registerPanel.addComponent(new Label("Username:"));
        usernameField = new TextBox(TEXT_FIELD_SIZE);
        registerPanel.addComponent(usernameField);
        registerPanel.addComponent(new Label("Password:"));
        passwordField = new TextBox(TEXT_FIELD_SIZE).setMask('*');
        registerPanel.addComponent(passwordField);
        registerPanel.addComponent(new Button("Register", this::navigateToLoginView));

        window.setComponent(registerPanel.withBorder(Borders.doubleLineReverseBevel()));
        window.setHints(Collections.singleton(Window.Hint.CENTERED));

        log.debug("RegistrationView components initialized");
    }

    public void display() {
        log.info("Displaying RegistrationView");
        initializeComponents();
        gui.addWindowAndWait(window);
        log.info("Closed the RegistrationView");
    }

    private void navigateToLoginView() {
        if (navigateToLoginButtonPress != null) {
            log.info("Navigating to RegistrationView");
            navigateToLoginButtonPress.run();
        } else {
            log.warn("Navigate to login button press handler is not set");
        }
    }

    public void setNavigateToLoginButtonPress(Runnable navigateToLoginButtonPress) {
        this.navigateToLoginButtonPress = navigateToLoginButtonPress;
    }

    public void close() {
        window.close();
        log.info("RegistrationView window closed");
    }
}
