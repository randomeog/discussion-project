package com.example.funproject.request;

public class PostRequest {

    private Integer postId;
    private String postName;
    private String description;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

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


    public PostRequest(Integer postId, String postName, String description) {
        this.postId = postId;
        this.postName = postName;
        this.description = description;
    }
}
