package archives.gpt;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Screen screen = new DefaultTerminalFactory().createScreen();
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);

        showMainMenu(gui);
//        try {
//            Screen screen = new DefaultTerminalFactory().createScreen();
//            screen.startScreen();
//            WindowBasedTextGUI gui = new MultiWindowTextGUI(screen);
//
//            WalletService walletService = new WalletService();
//            WalletView walletView = new WalletView(gui);
//            WalletController walletController = new WalletController(walletService, walletView);
//
//            // Start app by displaying all wallets
//            walletController.showAllWallets();
//
//            screen.stopScreen();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private static void showMainMenu(MultiWindowTextGUI gui) {
        BasicWindow mainMenu = new BasicWindow("Finance Manager again.Main Menu");
        Panel mainPanel = new Panel(new GridLayout(1));

        mainPanel.addComponent(new Button("User Registration", () -> showRegistrationScreen(gui)));
        mainPanel.addComponent(new Button("User Login", () -> showLoginScreen(gui)));
        mainPanel.addComponent(new Button("Wallet Management", () -> showWalletManagementScreen(gui)));
        mainPanel.addComponent(new Button("Record Transaction", () -> showTransactionScreen(gui)));
        mainPanel.addComponent(new Button("View Transactions", () -> showTransactionHistoryScreen(gui)));
        mainPanel.addComponent(new Button("Generate Financial Reports", () -> showReportScreen(gui)));
        mainPanel.addComponent(new Button("Currency Converter", () -> showCurrencyConverterScreen(gui)));
        mainPanel.addComponent(new Button("Exit", mainMenu::close));

        mainMenu.setComponent(mainPanel);
        gui.addWindowAndWait(mainMenu);
    }

    private static void showRegistrationScreen(MultiWindowTextGUI gui) {
        BasicWindow registerWindow = new BasicWindow("User Registration");
        Panel panel = new Panel(new GridLayout(2));

        panel.addComponent(new Label("Username:"));
        TextBox username = new TextBox();
        panel.addComponent(username);

        panel.addComponent(new Label("Password:"));
        TextBox password = new TextBox().setMask('*');
        panel.addComponent(password);

        panel.addComponent(new Button("Register", registerWindow::close));
        registerWindow.setComponent(panel);
        gui.addWindowAndWait(registerWindow);
    }

    private static void showLoginScreen(MultiWindowTextGUI gui) {
        BasicWindow loginWindow = new BasicWindow("User Login");
        Panel panel = new Panel(new GridLayout(2));

        panel.addComponent(new Label("Username:"));
        TextBox username = new TextBox();
        panel.addComponent(username);

        panel.addComponent(new Label("Password:"));
        TextBox password = new TextBox().setMask('*');
        panel.addComponent(password);

        panel.addComponent(new Button("Login", loginWindow::close));
        loginWindow.setComponent(panel);
        gui.addWindowAndWait(loginWindow);
    }

    private static void showWalletManagementScreen(MultiWindowTextGUI gui) {
        BasicWindow walletWindow = new BasicWindow("Wallet Management");
        Panel panel = new Panel(new GridLayout(1));

        panel.addComponent(new Button("Add Wallet", () -> showAddWalletScreen(gui)));
        panel.addComponent(new Button("View Wallets", () -> showViewWalletsScreen(gui)));
        panel.addComponent(new Button("Edit Wallet", () -> showEditWalletScreen(gui)));
        panel.addComponent(new Button("Delete Wallet", () -> showDeleteWalletScreen(gui)));

        walletWindow.setComponent(panel);
        gui.addWindowAndWait(walletWindow);
    }

    private static void showAddWalletScreen(MultiWindowTextGUI gui) {
        BasicWindow addWalletWindow = new BasicWindow("Add New Wallet");
        Panel panel = new Panel(new GridLayout(2));

        panel.addComponent(new Label("Wallet Name:"));
        TextBox walletName = new TextBox();
        panel.addComponent(walletName);

        panel.addComponent(new Label("Initial Balance:"));
        TextBox balance = new TextBox();
        panel.addComponent(balance);

        panel.addComponent(new Label("Currency:"));
        TextBox currency = new TextBox();
        panel.addComponent(currency);

        panel.addComponent(new Button("Save", addWalletWindow::close));
        addWalletWindow.setComponent(panel);
        gui.addWindowAndWait(addWalletWindow);
    }

    private static void showViewWalletsScreen(MultiWindowTextGUI gui) {
        MessageDialog.showMessageDialog(gui, "View Wallets", "List of wallets would be shown here.", MessageDialogButton.OK);
    }

    private static void showEditWalletScreen(MultiWindowTextGUI gui) {
        MessageDialog.showMessageDialog(gui, "Edit Wallet", "Wallet editing functionality would be shown here.", MessageDialogButton.OK);
    }

    private static void showDeleteWalletScreen(MultiWindowTextGUI gui) {
        MessageDialog.showMessageDialog(gui, "Delete Wallet", "Wallet deletion functionality would be shown here.", MessageDialogButton.OK);
    }

    private static void showTransactionScreen(MultiWindowTextGUI gui) {
        BasicWindow transactionWindow = new BasicWindow("Record Transaction");
        Panel panel = new Panel(new GridLayout(2));

        panel.addComponent(new Label("Amount:"));
        TextBox amount = new TextBox();
        panel.addComponent(amount);

        panel.addComponent(new Label("Date (YYYY-MM-DD):"));
        TextBox date = new TextBox();
        panel.addComponent(date);

        panel.addComponent(new Label("Category:"));
        TextBox category = new TextBox();
        panel.addComponent(category);

        panel.addComponent(new Label("Notes:"));
        TextBox notes = new TextBox();
        panel.addComponent(notes);

        panel.addComponent(new Button("Save Transaction", transactionWindow::close));
        transactionWindow.setComponent(panel);
        gui.addWindowAndWait(transactionWindow);
    }

    private static void showTransactionHistoryScreen(MultiWindowTextGUI gui) {
        BasicWindow historyWindow = new BasicWindow("Transaction History");
        Panel filterPanel = new Panel(new GridLayout(2));

        filterPanel.addComponent(new Label("Filter by Date:"));
        TextBox dateFilter = new TextBox();
        filterPanel.addComponent(dateFilter);

        filterPanel.addComponent(new Label("Filter by Category:"));
        TextBox categoryFilter = new TextBox();
        filterPanel.addComponent(categoryFilter);

        filterPanel.addComponent(new Label("Filter by Amount:"));
        TextBox amountFilter = new TextBox();
        filterPanel.addComponent(amountFilter);

        Panel transactionListPanel = new Panel(new GridLayout(1));
        transactionListPanel.addComponent(new Label("Transaction List (Filtered Results)"));

        historyWindow.setComponent(new Panel(new GridLayout(1))
                .addComponent(filterPanel)
                .addComponent(transactionListPanel)
                .addComponent(new Button("Close", historyWindow::close))
        );

        gui.addWindowAndWait(historyWindow);
    }

    private static void showReportScreen(MultiWindowTextGUI gui) {
        BasicWindow reportWindow = new BasicWindow("Financial Reports");
        Panel panel = new Panel(new GridLayout(1));

        panel.addComponent(new Button("Generate Monthly Report", () -> {}));
        panel.addComponent(new Button("Generate Yearly Report", () -> {}));
        panel.addComponent(new Button("Export to CSV", reportWindow::close));
        panel.addComponent(new Button("Export to PDF", reportWindow::close));

        reportWindow.setComponent(panel);
        gui.addWindowAndWait(reportWindow);
    }

    private static void showCurrencyConverterScreen(MultiWindowTextGUI gui) {
        BasicWindow currencyWindow = new BasicWindow("Currency Converter");
        Panel panel = new Panel(new GridLayout(2));

        panel.addComponent(new Label("Amount:"));
        TextBox amount = new TextBox();
        panel.addComponent(amount);

        panel.addComponent(new Label("From Currency:"));
        TextBox fromCurrency = new TextBox();
        panel.addComponent(fromCurrency);

        panel.addComponent(new Label("To Currency:"));
        TextBox toCurrency = new TextBox();
        panel.addComponent(toCurrency);

        panel.addComponent(new Button("Convert", currencyWindow::close));
        currencyWindow.setComponent(panel);
        gui.addWindowAndWait(currencyWindow);
    }
}
