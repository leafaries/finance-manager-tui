package com.leafaries.tui.model;

public class UserLoginDto {
    public String username;
    public String password;

    public UserLoginDto(String password, String username) {
        this.password = password;
        this.username = username;
    }
}
