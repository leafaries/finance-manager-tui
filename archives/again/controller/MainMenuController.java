package archives.again.controller;

import archives.again.service.CategoryService;
import archives.again.service.ReportService;
import archives.again.service.TransactionService;
import archives.again.service.WalletService;
import archives.again.view.MainMenuView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainMenuController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainMenuController.class);

    private final MainMenuView mainMenuView;
    private final WalletService walletService;
    private final TransactionService transactionService;
    private final ReportService reportService;
    private final CategoryService categoryService;

    public MainMenuController(WalletService walletService, TransactionService transactionService,
                              ReportService reportService, CategoryService categoryService) {
        this.walletService = walletService;
        this.transactionService = transactionService;
        this.reportService = reportService;
        this.categoryService = categoryService;
        this.mainMenuView = new MainMenuView(this);
    }

    public void handleUserInput(KeyStroke keyStroke) {
        KeyType keyType = keyStroke.getKeyType();

        switch (keyType) {
            case Enter:
                String selectedOption = mainMenuView.getSelectedOption();
                LOGGER.info("Selected option: {}", selectedOption);
                switch (selectedOption) {
                    case "Wallets":
                        new WalletController(walletService).start();
                        break;
                    case "Transactions":
                        new TransactionController(transactionService).start();
                        break;
                    case "Reports":
                        new ReportController(reportService).start();
                        break;
                    case "Categories":
                        new CategoryController(categoryService).start();
                        break;
                    case "Exit":
                        LOGGER.info("Exiting application...");
                        System.exit(0);
                        break;
                    default:
                        LOGGER.warn("Invalid selection.");
                        break;
                }
                break;
            case ArrowUp:
                mainMenuView.navigateUp();
                break;
            case ArrowDown:
                mainMenuView.navigateDown();
                break;
            default:
                LOGGER.info("Unhandled key type: {}", keyType);
                break;
        }
    }

    public void start() {
        mainMenuView.show();
    }
}
