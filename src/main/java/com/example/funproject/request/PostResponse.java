package com.example.funproject.request;

public class PostResponse {

    private String postName;
    private String description;
    private String userName;


    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PostResponse(String postName, String description, String userName) {
        this.postName = postName;
        this.description = description;
        this.userName = userName;
    }
}
