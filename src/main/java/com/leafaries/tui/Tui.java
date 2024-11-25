package com.leafaries.tui;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;

public class Tui {
    private final Screen screen;
    private final WindowBasedTextGUI gui;

    public Tui() throws IOException {
        this.screen = new DefaultTerminalFactory().createScreen();
        this.screen.startScreen();
        this.gui = new MultiWindowTextGUI(screen);
    }

    public WindowBasedTextGUI getGui() {
        return gui;
    }

    public void cleanup() throws IOException {
        this.screen.stopScreen();
    }
}
