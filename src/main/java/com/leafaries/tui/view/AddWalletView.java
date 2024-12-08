package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AddWalletView {

    private final WindowBasedTextGUI gui;

    public BasicWindow createWindow() {
        BasicWindow window = new BasicWindow("Add Wallet");
        Panel addWalletPanel = new Panel(new GridLayout(2));

        addWalletPanel.addComponent(new Label("Name:"));
        TextBox nameField = new TextBox();
        addWalletPanel.addComponent(nameField);

        addWalletPanel.addComponent(new Label("Balance:"));
        TextBox balanceField = new TextBox();
        addWalletPanel.addComponent(balanceField);

        addWalletPanel.addComponent(new Label("Currency:"));
        TextBox currencyField = new TextBox();
        addWalletPanel.addComponent(currencyField);

        addWalletPanel.addComponent(new Button("Save", () -> {
            // Implement backend API call to save wallet
            window.close();
        }));

        window.setComponent(addWalletPanel);
        return window;
    }

}
