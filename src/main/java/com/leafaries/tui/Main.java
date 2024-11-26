package com.leafaries.tui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        Tui tui = new Tui();

        Application app = new Application(tui.getGui());
        app.run();

        tui.cleanup();
    }
}
