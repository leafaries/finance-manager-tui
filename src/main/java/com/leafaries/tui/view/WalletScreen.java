package com.leafaries.tui.view;

import com.googlecode.lanterna.gui2.*;
import org.springframework.stereotype.Component;

@Component
public class WalletScreen {
    private final WindowBasedTextGUI gui;

    public WalletScreen(WindowBasedTextGUI gui) {
        this.gui = gui;
    }

    public void show() {
        BasicWindow window = new BasicWindow("Wallet Management");
        Panel walletPanel = new Panel(new GridLayout(1));

        walletPanel.addComponent(new Button("Add Wallet", () -> {
            gui.addWindowAndWait(new AddWalletView(gui).createWindow());
        }));
        walletPanel.addComponent(new Button("View Wallets", () -> {
            gui.addWindowAndWait(new ViewWalletsView(gui).createWindow());
        }));
//        walletPanel.addComponent(new Button("Edit Wallet", () -> {
//            gui.addWindowAndWait(new EditWalletView(gui).createWindow());
//        }));
//        walletPanel.addComponent(new Button("Delete Wallet", () -> {
//            gui.addWindowAndWait(new DeleteWalletView(gui).createWindow());
//        }));

        window.setComponent(walletPanel);
        gui.addWindowAndWait(window);
    }
}
