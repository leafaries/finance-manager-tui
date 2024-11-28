package com.leafaries.tui.model;

public class UserRegistrationDto {
    public String username;
    public String password;

    public UserRegistrationDto(String password, String username) {
        this.password = password;
        this.username = username;
    }
}
