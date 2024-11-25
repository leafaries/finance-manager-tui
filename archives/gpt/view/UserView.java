//package gpt.view;
//
//import com.googlecode.lanterna.gui2.*;
//import gpt.controller.UserController;
//import gpt.util.WindowUtils;
//
//public class UserView {
//
//    private static final UserController userController = new UserController();
//
//    public static void showRegistrationScreen(MultiWindowTextGUI gui) {
//        BasicWindow registerWindow = new BasicWindow("User Registration");
//        Panel panel = new Panel(new GridLayout(2));
//
//        panel.addComponent(new Label("Username:"));
//        TextBox username = new TextBox();
//        panel.addComponent(username);
//
//        panel.addComponent(new Label("Password:"));
//        TextBox password = new TextBox().setMask('*');
//        panel.addComponent(password);
//
//        panel.addComponent(new Button("Register", () -> {
//            String usernameText = username.getText();
//            String passwordText = password.getText();
//            userController.handleRegistration(gui, usernameText, passwordText);
//        }));
//
//        registerWindow.setComponent(panel);
//
//        WindowUtils.closeWindowOnKeyPress(gui, registerWindow, KeyType.Escape);
//        gui.addWindowAndWait(registerWindow);
//    }
//
//    public static void showLoginScreen(MultiWindowTextGUI gui) {
//        BasicWindow loginWindow = new BasicWindow("User Login");
//        Panel panel = new Panel(new GridLayout(2));
//
//        panel.addComponent(new Label("Username:"));
//        TextBox username = new TextBox();
//        panel.addComponent(username);
//
//        panel.addComponent(new Label("Password:"));
//        TextBox password = new TextBox().setMask('*');
//        panel.addComponent(password);
//
//        panel.addComponent(new Button("Login", () -> {
//            String usernameText = username.getText();
//            String passwordText = password.getText();
//            userController.handleLogin(gui, usernameText, passwordText);
//        }));
//
//        loginWindow.setComponent(panel);
//
//        WindowUtils.closeWindowOnKeyPress(gui, loginWindow, KeyType.Escape);
//        gui.addWindowAndWait(loginWindow);
//    }
//}
