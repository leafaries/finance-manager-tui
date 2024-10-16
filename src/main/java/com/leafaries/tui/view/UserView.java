package com.leafaries.tui.view;

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
    }
}
