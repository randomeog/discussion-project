package com.example.funproject.request;

public class AuthResponse {

    private String authToken;
    private String username;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthResponse(String authToken, String username) {
        this.authToken = authToken;
        this.username = username;
    }
}
