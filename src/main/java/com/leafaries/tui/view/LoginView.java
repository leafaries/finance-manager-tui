package com.leafaries.tui.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class LoginView {
    private static final TerminalSize TEXT_FIELD_SIZE = new TerminalSize(16, 1);

    private static final Logger log = LoggerFactory.getLogger(LoginView.class);

    private final WindowBasedTextGUI gui;
    private final BasicWindow window;
    private TextBox usernameField;
    private TextBox passwordField;
    private Runnable handleLoginButtonPress;
    private Runnable navigateToRegistrationButtonPress;

    public LoginView(WindowBasedTextGUI gui) {
        this.gui = gui;
        this.window = new BasicWindow("Login");
    }

    private void initializeComponents() {
        log.debug("Initializing LoginView components");
        Panel panel = new Panel();

        Label usernameLabel = new Label("Username");
        usernameField = new TextBox(TEXT_FIELD_SIZE);

        Label passwordLabel = new Label("Password");
        passwordField = new TextBox(TEXT_FIELD_SIZE).setMask('*');

        panel.addComponent(usernameLabel);
        panel.addComponent(usernameField);

        panel.addComponent(passwordLabel);
        panel.addComponent(passwordField);

        panel.addComponent(new Button("Login", this::handleLogin));
        panel.addComponent(new Button("Don't have account?", this::navigateToRegistrationView));

        window.setComponent(panel.withBorder(Borders.doubleLineReverseBevel()));
        window.setHints(Collections.singleton(Window.Hint.CENTERED));

        log.debug("LoginView components initialized");
    }

    public void display() {
        log.info("Displaying the LoginView");
        initializeComponents();
        gui.addWindowAndWait(window);
        log.info("Closed the LoginView");
    }

    public void showMessage(String message) {
        log.info("Display message dialog with message: {}", message);
        MessageDialog.showMessageDialog(gui, "Message", message, MessageDialogButton.OK);
    }

    private void handleLogin() {
        if (handleLoginButtonPress != null) {
            log.info("Login button pressed");
            handleLoginButtonPress.run();
        } else {
            log.warn("Login button press handler is not set");
        }
    }

    private void navigateToRegistrationView() {
        if (navigateToRegistrationButtonPress != null) {
            log.info("Navigating to RegistrationView");
            navigateToRegistrationButtonPress.run();
        } else {
            log.warn("Navigate to registration button press handler is not set");
        }
    }

    public void setHandleLoginButtonPress(Runnable handleLoginButtonPress) {
        this.handleLoginButtonPress = handleLoginButtonPress;
        log.debug("Set login button press handler");
    }

    public void setNavigateToRegistrationButtonPress(Runnable navigateToRegistrationButtonPress) {
        this.navigateToRegistrationButtonPress = navigateToRegistrationButtonPress;
        log.debug("Set navigate to registration button press handler");
    }

    public String getPassword() {
        log.debug("Getting password field");
        return passwordField.getText();
    }

    public String getUsername() {
        log.debug("Getting username field");
        return usernameField.getText();
    }

    public void close() {
        window.close();
        log.info("LoginView window closed");
    }
}
