package com.example.funproject.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

import com.example.funproject.models.User;

@Entity
public class Tag {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tagId;
    private String tagName;
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Post> posts;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Tag(Integer tagId, String tagName, String description, List<Post> posts, User user) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.description = description;
        this.posts = posts;
        this.user = user;
    }

    public Tag() {

    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;
        Tag tag = (Tag) o;
        return Objects.equals(tagId, tag.tagId) && Objects.equals(tagName, tag.tagName) && Objects.equals(description, tag.description) && Objects.equals(posts, tag.posts) && Objects.equals(user, tag.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId, tagName, description, posts, user);
    }
}
