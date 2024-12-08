package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@AllArgsConstructor
@Component
public class MainMenuView {

    private final WindowBasedTextGUI gui;

    public void display() {
        BasicWindow mainMenuWindow = new BasicWindow("Main Menu");
        mainMenuWindow.setHints(Collections.singleton(Window.Hint.CENTERED));
        Panel mainMenuPanel = new Panel(new GridLayout(1));

//        mainMenuPanel.addComponent(new Button("Register", () -> {
//            gui.addWindowAndWait(registrationView.createWindow());
//        }));
//        mainMenuPanel.addComponent(new Button("Transactions", () -> {
//            gui.addWindowAndWait(transactionView.createUserManagementWindow());
//        }));
//        mainMenuPanel.addComponent(new Button("Manage Users", () -> {
//            gui.addWindowAndWait(walletScreen.show());
//        }));

        mainMenuWindow.setComponent(mainMenuPanel);
        gui.addWindowAndWait(mainMenuWindow);
    }

}
