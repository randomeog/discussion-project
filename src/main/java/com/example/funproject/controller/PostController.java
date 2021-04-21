package com.example.funproject.controller;

import com.example.funproject.repositories.PostRepository;
import com.example.funproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostController {


    PostRepository postRepository;
    UserRepository userRepository;

}
