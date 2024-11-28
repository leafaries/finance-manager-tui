package com.leafaries.tui.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.leafaries.tui.exceptions.ScreenInitializationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Configuration
@ComponentScan(basePackages = {"com.leafaries.tui"})
public class AppConfig implements DisposableBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);

    private Screen screen;

    @Bean
    public WindowBasedTextGUI gui() {
        try {
            LOGGER.info("Creating and starting the screen");
            this.screen = new DefaultTerminalFactory().createScreen();
            this.screen.startScreen();
            return new MultiWindowTextGUI(screen);
        } catch (IOException e) {
            LOGGER.error("Failed to create and start the screen", e);
            throw new ScreenInitializationException("Failed to create and start the screen", e);
        }
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://localhost:8080/").build();
    }

    @Override
    public void destroy() throws Exception {
        if (this.screen != null) {
            try {
                LOGGER.info("Stopping the screen");
                this.screen.stopScreen();
            } catch (IOException e) {
                LOGGER.error("Failed to stop the screen", e);
            }
        }
    }
}
