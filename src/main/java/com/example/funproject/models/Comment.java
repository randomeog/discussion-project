package com.example.funproject.models;


import javax.persistence.*;

@Entity
public class Comment {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int comment_Id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Comment() {
    }

    public int getComment_Id() {
        return comment_Id;
    }

    public void setComment_Id(int comment_Id) {
        this.comment_Id = comment_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
