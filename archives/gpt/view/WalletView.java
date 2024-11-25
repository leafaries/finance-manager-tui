package archives.gpt.view;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.input.KeyType;
import archives.gpt.WindowUtils;
import archives.gpt.model.Wallet;

import java.util.List;

public class WalletView {

    private final WindowBasedTextGUI gui;

    public WalletView(WindowBasedTextGUI gui) {
        this.gui = gui;
    }

    public void displayWallets(List<Wallet> wallets) {
        // Display wallets in a Lanterna table or list format

        // Create a new window for displaying wallets
        BasicWindow walletWindow;
        walletWindow = new BasicWindow("Wallets");
        Panel panel = new Panel(new GridLayout(2));

        // Add wallet data to the panel
        for (Wallet wallet : wallets) {
            panel.addComponent(new Label(wallet.getName()));
            panel.addComponent(new Label(String.format("%.2f %s", wallet.getBalance(), wallet.getCurrency())));
        }

        walletWindow.setComponent(panel);
        gui.addWindow(walletWindow); // Open window

        // Close the window when 'ESC' is pressed
        WindowUtils.closeWindowOnKeyPress(gui, walletWindow, KeyType.Escape);

        gui.addWindowAndWait(walletWindow);  // Open window and wait for it to close
    }

    public void displayMessage(String message) {
//        MessageDialog.showMessageDialog(textGui, "Message", message, MessageDialogButton.OK);

        BasicWindow messageWindow = new BasicWindow("Message");
        Panel panel = new Panel(new LinearLayout(Direction.VERTICAL));

        panel.addComponent(new Label(message));
        panel.addComponent(new Button("OK", messageWindow::close));

        messageWindow.setComponent(panel);
        gui.addWindowAndWait(messageWindow);  // Display the message window
    }
}
