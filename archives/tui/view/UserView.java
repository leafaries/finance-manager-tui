package archives.tui.view;

import com.googlecode.lanterna.gui2.*;

import java.util.List;

public class UserView {

    private final WindowBasedTextGUI gui;

    public UserView(WindowBasedTextGUI gui) {
        this.gui = gui;
    }

    public void displayUsers(List<String> users) {
        // Create a window to display user list
        BasicWindow window = new BasicWindow("User List");

        BasicWindow mainMenu = new BasicWindow("Finance Manager");
        Panel mainPanel = new Panel(new GridLayout(2));

        mainPanel.addComponent(new Button("Register", () -> openRegistrationScreen()));
//        mainPanel.addComponent(new Button("Login", () -> openLoginScreen(gui)));
        mainPanel.addComponent(new Button("Manage Wallets", () -> openWalletScreen()));
        mainPanel.addComponent(new Button("Record Transaction", () -> openTransactionScreen()));
        mainPanel.addComponent(new Button("View Reports", () -> openReportScreen()));
        mainPanel.addComponent(new Button("Currency Converter", () -> openCurrencyScreen()));

        mainMenu.setComponent(mainPanel);
        gui.addWindowAndWait(mainMenu);

        /*
        // Create a panel to hold the components
        Panel panel = new Panel();
        panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));

        // Add each user to the panel
        for (String user : users) {
            panel.addComponent(new Label(user));
        }

        // Add a close button
        Button closeButton = new Button("Close", window::close);
        panel.addComponent(closeButton);

        // Set the panel as the window's component
        window.setComponent(panel);

        // Show the window
        gui.addWindowAndWait(window);
         */
    }

    private void openRegistrationScreen() {
        BasicWindow registerWindow = new BasicWindow("Register");
        Panel registerPanel = new Panel(new GridLayout(2));

        registerPanel.addComponent(new Label("Username:"));
        TextBox usernameField = new TextBox();
        registerPanel.addComponent(usernameField);

        registerPanel.addComponent(new Label("Password:"));
        TextBox passwordField = new TextBox().setMask('*');
        registerPanel.addComponent(passwordField);

        registerPanel.addComponent(new Button("Submit", () -> {
            // Implement backend API call for registration
            registerWindow.close();
        }));

        registerWindow.setComponent(registerPanel);
        gui.addWindowAndWait(registerWindow);
    }

    private void openWalletScreen() {
//        BasicWindow walletWindow = new BasicWindow("Wallet Management");
//        Panel walletPanel = new Panel(new GridLayout(1));
//
//        walletPanel.addComponent(new Button("Add Wallet", () -> openAddWalletScreen()));
//        walletPanel.addComponent(new Button("View Wallets", () -> openViewWalletsScreen()));
//        walletPanel.addComponent(new Button("Edit Wallet", () -> openEditWalletScreen()));
//        walletPanel.addComponent(new Button("Delete Wallet", () -> openDeleteWalletScreen()));
//
//        walletWindow.setComponent(walletPanel);
//        gui.addWindowAndWait(walletWindow);
    }

    private void openTransactionScreen() {
        BasicWindow transactionWindow = new BasicWindow("Record Transaction");
        Panel transactionPanel = new Panel(new GridLayout(2));

        transactionPanel.addComponent(new Label("Amount:"));
        TextBox amountField = new TextBox();
        transactionPanel.addComponent(amountField);

        transactionPanel.addComponent(new Label("Date (YYYY-MM-DD):"));
        TextBox dateField = new TextBox();
        transactionPanel.addComponent(dateField);

        transactionPanel.addComponent(new Label("Category:"));
        TextBox categoryField = new TextBox();
        transactionPanel.addComponent(categoryField);

        transactionPanel.addComponent(new Label("Notes (optional):"));
        TextBox notesField = new TextBox();
        transactionPanel.addComponent(notesField);

        transactionPanel.addComponent(new Button("Save", () -> {
            // Implement backend API call to save transaction
            transactionWindow.close();
        }));

        transactionWindow.setComponent(transactionPanel);
        gui.addWindowAndWait(transactionWindow);
    }

    private void openReportScreen() {
        BasicWindow reportWindow = new BasicWindow("Generate Financial Report");
        Panel reportPanel = new Panel(new GridLayout(1));

//        reportPanel.addComponent(new Button("Monthly Report", () -> generateMonthlyReport()));
//        reportPanel.addComponent(new Button("Yearly Report", () -> generateYearlyReport()));
//        reportPanel.addComponent(new Button("Export as CSV", () -> exportReportAsCSV()));
//        reportPanel.addComponent(new Button("Export as PDF", () -> exportReportAsPDF()));

        reportWindow.setComponent(reportPanel);
        gui.addWindowAndWait(reportWindow);
    }

    private void openCurrencyScreen() {
        BasicWindow currencyWindow = new BasicWindow("Currency Converter");
        Panel currencyPanel = new Panel(new GridLayout(2));

        currencyPanel.addComponent(new Label("Amount:"));
        TextBox amountField = new TextBox();
        currencyPanel.addComponent(amountField);

        currencyPanel.addComponent(new Label("From Currency:"));
        TextBox fromCurrencyField = new TextBox();
        currencyPanel.addComponent(fromCurrencyField);

        currencyPanel.addComponent(new Label("To Currency:"));
        TextBox toCurrencyField = new TextBox();
        currencyPanel.addComponent(toCurrencyField);

        currencyPanel.addComponent(new Button("Convert", () -> {
            // Implement backend API call for conversion
            currencyWindow.close();
        }));

        currencyWindow.setComponent(currencyPanel);
        gui.addWindowAndWait(currencyWindow);
    }
}
