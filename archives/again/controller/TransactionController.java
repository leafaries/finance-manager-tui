package archives.again.controller;

import archives.again.service.TransactionService;
import archives.again.view.TransactionView;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionService transactionService;
    private final TransactionView transactionsView;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
        this.transactionsView = new TransactionView(this);
    }

    public void handleUserInput(KeyStroke keyStroke) {
        KeyType keyType = keyStroke.getKeyType();

        switch (keyType) {
            case ArrowUp:
                transactionsView.navigateUp();
                break;
            case ArrowDown:
                transactionsView.navigateDown();
                break;
            case Enter:
                String selectedTransaction = transactionsView.getSelectedOption();
                LOGGER.info("Selected transaction: {}", selectedTransaction);
                // Perform actions like viewing or editing the transaction
                break;
            case Character:
                if (keyStroke.getCharacter() == 'n') {
                    LOGGER.info("Adding a new transaction.");
                    transactionsView.addTransaction();
                } else if (keyStroke.getCharacter() == 'd') {
                    LOGGER.info("Deleting the selected transaction.");
                    transactionsView.deleteTransaction();
                }
                break;
            case Escape:
                LOGGER.info("Returning to main menu.");
                return;
            default:
                LOGGER.warn("Unhandled key type: {}", keyType);
                break;
        }
    }

    public void start() {
        transactionsView.show();
    }
}