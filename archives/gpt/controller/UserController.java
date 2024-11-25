//package gpt.controller;
//
//import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
//import gpt.service.UserService;
//import gpt.view.UserView;
//import gpt.model.User;
//
//public class UserController {
//
//    private final UserService userService;
//
//    public UserController() {
//        this.userService = new UserService();
//    }
//
//    public void handleRegistration(MultiWindowTextGUI gui, String username, String password) {
//        // Call service to register the user
//        User newUser = userService.registerUser(username, password);
//
//        if (newUser != null) {
//            UserView.showLoginScreen(gui); // Redirect to login after successful registration
//        } else {
//            UserView.showRegistrationScreen(gui); // Stay on registration screen if failed
//        }
//    }
//
//    public void handleLogin(MultiWindowTextGUI gui, String username, String password) {
//        // Call service to authenticate the user
//        User loggedInUser = userService.loginUser(username, password);
//
//        if (loggedInUser != null) {
//            // Proceed to main menu or next screen
//            UserView.showMainMenu(gui);
//        } else {
//            UserView.showLoginScreen(gui); // Stay on login screen if authentication fails
//        }
//    }
//}
