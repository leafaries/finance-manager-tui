package com.leafaries.tui.model;

public class UserDto {
    public Long id;
    public String username;
    public String password;

    public UserDto(Long id, String password, String username) {
        this.id = id;
        this.password = password;
        this.username = username;
    }
}
