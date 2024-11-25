package com.leafaries.tui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            Tui tui = new Tui();
            Application app = new Application(tui.getGui());
            app.run();
            tui.cleanup();
        } catch (Exception e) {
            LOGGER.error("Error during application startup: ", e);
        }
    }
}
