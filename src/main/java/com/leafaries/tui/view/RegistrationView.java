package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;

public class RegistrationView {
    private final WindowBasedTextGUI gui;

    public RegistrationView(WindowBasedTextGUI gui) {
        this.gui = gui;
    }

    public void show() {
        BasicWindow mainMenuWindow = new BasicWindow("Register");
        Panel registerPanel = new Panel(new GridLayout(2));

        registerPanel.addComponent(new Label("Username:"));
        TextBox usernameField = new TextBox();
        registerPanel.addComponent(usernameField);

        registerPanel.addComponent(new Label("password:"));
        TextBox passwordField = new TextBox().setMask('*');
        registerPanel.addComponent(passwordField);

        registerPanel.addComponent(new Button("Register", () -> {
            new RegistrationView(gui).show();
        }));
        // Repeat simlar actions for other screens

        mainMenuWindow.setComponent(registerPanel);
        gui.addWindowAndWait(registerPanel);
    }
}
