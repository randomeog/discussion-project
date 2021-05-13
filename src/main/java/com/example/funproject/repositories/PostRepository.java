package com.example.funproject.repositories;

import com.example.funproject.models.Post;
import com.example.funproject.models.Tag;
import com.example.funproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUser (User user);
}
