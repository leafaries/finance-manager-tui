package archives.again.view;


import archives.again.controller.MainMenuController;
import com.googlecode.lanterna.gui2.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class MainMenuView {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainMenuView.class);

    private final MainMenuController mainMenuController;
    private final MultiWindowTextGUI gui;

    public MainMenuView(MainMenuController mainMenuController, MultiWindowTextGUI gui) {
        this.mainMenuController = mainMenuController;
        this.gui = gui;
    }

    public void display() {
        BasicWindow window = new BasicWindow("Main Menu");
        Panel panel = new Panel();

        Button walletsButton = new Button("Manage Wallets", () -> mainMenuController.onWalletsSelected());
        Button transactionsButton = new Button("View Transactions", () -> mainMenuController.onTransactionsSelected());
        Button reportsButton = new Button("Generate Reports", () -> mainMenuController.onReportsSelected());
        Button categoriesButton = new Button("Manage Categories", () -> mainMenuController.onCategoriesSelected());
        Button quitButton = new Button("Quit", () -> mainMenuController.onQuitSelected());

        Arrays.asList(walletsButton, transactionsButton, reportsButton, categoriesButton, quitButton)
                .forEach(panel::addComponent);

        window.setComponent(panel);
        gui.addWindowAndWait(window);
    }}