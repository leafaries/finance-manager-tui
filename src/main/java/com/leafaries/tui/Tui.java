package com.leafaries.tui;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Tui {
    private static final Logger LOGGER = LoggerFactory.getLogger(Tui.class);

    private final Screen screen;
    private final WindowBasedTextGUI gui;

    public Tui() {
        this.screen = createScreen();
        startScreen();
        this.gui = new MultiWindowTextGUI(screen);
    }

    @NotNull
    private Screen createScreen() {
        try {
            return new DefaultTerminalFactory().createScreen();
        } catch (IOException e) {
            LOGGER.error("Error creating screen: {}", e.getMessage());
            throw new RuntimeException("Failed to create screen", e);
        }
    }

    private void startScreen() {
        try {
            this.screen.startScreen();
        } catch (IOException e) {
            LOGGER.error("Error starting screen: {}", e.getMessage());
            throw new RuntimeException("Failed to start screen", e);
        }
    }

    public WindowBasedTextGUI getGui() {
        return gui;
    }

    public void cleanup() {
        try {
            this.screen.stopScreen();
        } catch (IOException e) {
            LOGGER.error("Error stopping screen: {}", e.getMessage());
            throw new RuntimeException("Failed to stop screen", e);
        }
    }
}
