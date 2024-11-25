package archives.again.view;


import archives.again.controller.WalletController;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Panel;

import java.util.List;

public class WalletView {
    private final WalletController walletController;
    private final MultiWindowTextGUI gui;

    public WalletView(WalletController walletController, MultiWindowTextGUI gui) {
        this.walletController = walletController;
        this.gui = gui;
    }

    public void display(List<String> wallets) {
        BasicWindow window = new BasicWindow("Wallet Management");
        Panel panel = new Panel();

        for (String wallet : wallets) {
            panel.addComponent(new Button(wallet, () -> walletController.onWalletSelected(wallet)));
        }

        panel.addComponent(new Button("Add Wallet", walletController::onAddWallet));
        panel.addComponent(new Button("Go Back", walletController::onBack));

        window.setComponent(panel);
        gui.addWindowAndWait(window);
    }
}
