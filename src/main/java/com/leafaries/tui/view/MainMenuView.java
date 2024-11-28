package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;
import org.springframework.stereotype.Component;

@Component
public class MainMenuView {
    private final WindowBasedTextGUI gui;

    private final RegistrationView registrationView;
    private final TransactionView transactionView;
    private final UserView userView;
    private final WalletScreen walletScreen;

    public MainMenuView(WindowBasedTextGUI gui,
                        RegistrationView registrationView,
                        TransactionView transactionView,
                        UserView userView,
                        WalletScreen walletScreen) {
        this.gui = gui;
        this.registrationView = registrationView;
        this.transactionView = transactionView;
        this.userView = userView;
        this.walletScreen = walletScreen;
    }

    public void display() {
        BasicWindow mainMenuWindow = new BasicWindow("Main Menu");
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
