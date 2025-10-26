package com.hng.profileapi.dto;

public class ProfileResponse {

    private String status;
    private UserDto user;
    private String timestamp;
    private String fact;

    public ProfileResponse(String status, UserDto user, String timestamp, String fact) {
        this.status = status;
        this.user = user;
        this.timestamp = timestamp;
        this.fact = fact;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}
