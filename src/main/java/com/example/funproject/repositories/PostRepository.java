package com.example.funproject.repositories;

import com.example.funproject.models.Post;
import com.example.funproject.models.Tag;
import com.example.funproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByTag (Tag tag);
    List<Post> findByUser (User user);
}
