package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoginView {
    private static final Logger logger = LoggerFactory.getLogger(LoginView.class);

    private final WindowBasedTextGUI gui;
    private final BasicWindow window;
    private TextBox usernameField;
    private TextBox passwordField;
    private Runnable handleLoginButtonPress;
    private Runnable navigateToRegistrationButtonPress;

    public LoginView(WindowBasedTextGUI gui,
                     RegistrationView registrationView,
                     MainMenuView mainMenuView) {
        this.gui = gui;
        this.window = new BasicWindow("Login");
        initializeComponents();
//        logger.info("LoginView initialized");
    }

    private void initializeComponents() {
        logger.debug("Initializing LoginView components");
        Panel panel = new Panel();

        Label usernameLabel = new Label("Username");
        usernameField = new TextBox();

        Label passwordLabel = new Label("Password");
        passwordField = new TextBox().setMask('*');

        panel.addComponent(usernameLabel);
        panel.addComponent(usernameField);

        panel.addComponent(passwordLabel);
        panel.addComponent(passwordField);

        panel.addComponent(new Button("Login", this::handleLogin));
        panel.addComponent(new Button("Don't have account?", this::navigateToRegistrationView));

        window.setComponent(panel.withBorder(Borders.singleLine())); // TODO: Change if looks bad
        logger.debug("LoginView components initialized");
    }

    public void display() {
        // Reset the state of the view
        logger.info("Displaying the LoginView");
        usernameField.setText("");
        passwordField.setText("");
        gui.addWindowAndWait(window);
    }

    public void showMessage(String message) {
        logger.info("Display message dialog with message: {}", message);
        MessageDialog.showMessageDialog(gui, "Message", message, MessageDialogButton.OK);
    }

    private void handleLogin() {
        if (handleLoginButtonPress != null) {
            logger.info("Login button pressed");
            handleLoginButtonPress.run();
        } else {
            logger.warn("Login button press handler is not set");
        }
    }

    private void navigateToRegistrationView() {
        if (navigateToRegistrationButtonPress != null) {
            logger.info("Navigating to RegistrationView");
            navigateToRegistrationButtonPress.run();
        } else {
            logger.warn("Navigate to registration button press handler is not set");
        }
    }

    public void setHandleLoginButtonPress(Runnable handleLoginButtonPress) {
        this.handleLoginButtonPress = handleLoginButtonPress;
        logger.debug("Set login button press handler");
    }

    public void setNavigateToRegistrationButtonPress(Runnable navigateToRegistrationButtonPress) {
        this.navigateToRegistrationButtonPress = navigateToRegistrationButtonPress;
        logger.debug("Set navigate to registration button press handler");
    }

    public String getPassword() {
        logger.debug("Getting password field");
        return passwordField.getText();
    }

    public String getUsername() {
        logger.debug("Getting username field");
        return usernameField.getText();
    }
}
