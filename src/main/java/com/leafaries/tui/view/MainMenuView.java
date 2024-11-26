package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;

public class MainMenuView {
    private final WindowBasedTextGUI gui;

    public MainMenuView(WindowBasedTextGUI gui) {
        this.gui = gui;
    }

    public void show() {
        BasicWindow mainMenuWindow = new BasicWindow("Main Menu"); // or "Finance Manager
        Panel mainPanel = new Panel(new GridLayout(2));

        mainPanel.addComponent(new Button("Register", () -> new RegistrationView(gui).show()));
        // Repeat simlar actions for other screens

        mainMenuWindow.setComponent(mainPanel);
        gui.addWindowAndWait(mainPanel);
    }
}
