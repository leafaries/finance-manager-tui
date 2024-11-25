package archives.again.controller;

/*
import archives.again.service.WalletService;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WalletController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WalletController.class);

    private final WalletService walletService;
    private final WalletsView walletsView;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
        this.walletsView = new WalletsView(this);
    }

    public void handleUserInput(KeyStroke keyStroke) {
        KeyType keyType = keyStroke.getKeyType();
        switch (keyType) {
            case Enter:
                // Handle selection of a wallet
                break;
            case ArrowUp:
                walletsView.navigateUp();
                break;
            case ArrowDown:
                walletsView.navigateDown();
                break;
            case Enter:
                String selectedWallet = walletsView.getSelectedOption();
                LOGGER.info("Selected wallet: {}", selectedWallet);
                // Perform actions like viewing wallet details or editing
                break;
            case Character:
                if (keyStroke.getCharacter() == 'n') {
                    LOGGER.info("Creating a new wallet.");
                    walletsView.createWallet();
                } else if (keyStroke.getCharacter() == 'd') {
                    LOGGER.info("Deleting the selected wallet.");
                    walletsView.deleteWallet();
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
        walletsView.show();
    }
}
*/
