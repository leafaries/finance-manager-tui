package com.leafaries.tui.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.leafaries.tui.exceptions.ScreenInitializationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Slf4j
@ComponentScan(basePackages = {"com.leafaries.tui"})
@Configuration
public class AppConfig implements DisposableBean {

    private Screen screen;

    @Bean
    public WindowBasedTextGUI gui() {
        try {
            log.info("Creating and starting the screen");
            this.screen = new DefaultTerminalFactory().createScreen();
            this.screen.startScreen();
            return new MultiWindowTextGUI(screen);
        } catch (IOException e) {
            log.error("Failed to create and start the screen", e);
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
                log.info("Stopping the screen");
                this.screen.stopScreen();
            } catch (IOException e) {
                log.error("Failed to stop the screen", e);
            }
        }
    }

}
