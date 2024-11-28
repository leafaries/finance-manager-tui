package com.leafaries.tui.exceptions;

public class ScreenInitializationException extends RuntimeException {
    public ScreenInitializationException(String message) {
        super(message);
    }

    public ScreenInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
