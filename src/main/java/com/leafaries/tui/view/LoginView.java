package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.leafaries.tui.controller.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class LoginView {
    private final WindowBasedTextGUI gui;
    private final RegistrationView registrationView;
    private final MainMenuView mainMenuView;
    private LoginController loginController;
    private BasicWindow window;
    private TextBox usernameField;
    private TextBox passwordField;

    public LoginView(WindowBasedTextGUI gui,
                     RegistrationView registrationView,
                     MainMenuView mainMenuView) {
        this.gui = gui;
        this.registrationView = registrationView;
        this.mainMenuView = mainMenuView;
        this.window = new BasicWindow("Login");
        initializeComponents();
    }


    @Autowired
    public void setLoginController(@Lazy LoginController loginController) {
        this.loginController = loginController;
    }

    private void initializeComponents() {
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
        panel.addComponent(new Button("Don't have account?", loginController::navigateToRegistrationView));

        window.setComponent(panel.withBorder(Borders.singleLine())); // TODO: Change if looks bad
    }

    public void display() {
        // Reset the state of the view
        usernameField.setText("");
        passwordField.setText("");
        gui.addWindowAndWait(window);
    }

    public void showMessage(String message) {
        MessageDialog.showMessageDialog(gui, "Message", message, MessageDialogButton.OK);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = usernameField.getText();
        loginController.handleLogin(username, password);
    }
}
