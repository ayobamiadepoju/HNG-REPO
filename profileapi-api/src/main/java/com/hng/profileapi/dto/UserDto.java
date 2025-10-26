package com.hng.profileapi.dto;

public class UserDto {

    private String name;
    private String email;
    private String stack;

    public UserDto() {
    }

    public UserDto(String name, String email, String stack) {
        this.name = name;
        this.email = email;
        this.stack = stack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
}
