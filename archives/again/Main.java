package archives.again;

import archives.again.view.MainMenuView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * The entry point of the Personal Finance Management Application.
 * Initializes the application, sets up logging, and starts the TUI interface.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    /**
     * The main method initializes the application and starts the Text User Interface (TUI).
     *
     * @param args Command-line arguments (not used in this case).
     */
    public static void main(String[] args) throws IOException {
        LOGGER.info("Application started.");

        try {
            ValidationUtils.validateApplicationStartup();

            MainMenuView mainMenu = new MainMenuView();
            mainMenuView.start();
        } catch (Exception e) {
            LOGGER.error("Error during application startup: ", e);
        } finally {
            LOGGER.info("Application shutdown.");
        }

        BackendService backendService = new BackendService();

        // Example: Fetch a post by ID
        int postID = 1;
        ApiResponse response = backendService.getPost(postID);

        if (response != null) {
            LOGGER.info("Post fetched successfully: {}", response);
        } else {
            LOGGER.info("Failed to fetch response");
        }
    }
}
