package archives.tui;

import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import archives.tui.controller.UserController;
import archives.tui.service.UserService;
import archives.tui.view.UserView;

public class Application {

    private final UserService userService;
    private final UserView userView;
    private final UserController userController;

    public Application(WindowBasedTextGUI gui) {
        // Initialize services and controllers
        this.userService = new UserService();
        this.userView = new UserView(gui);
        this.userController = new UserController(userService, userView);
    }

    public void run() {
        userController.showUsers();
    }
}
