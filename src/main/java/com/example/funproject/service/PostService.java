package com.example.funproject.service;

import com.example.funproject.exceptions.PostNotFoundException;
import com.example.funproject.mapper.PostMapper;
import com.example.funproject.models.Post;
import com.example.funproject.models.User;
import com.example.funproject.repositories.PostRepository;
import com.example.funproject.repositories.UserRepository;
import com.example.funproject.request.PostRequest;
import com.example.funproject.request.PostResponse;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;
    private RegistrationService registrationService;
    private PostMapper postMapper;

    @Transactional(readOnly = true)
    public PostResponse getPost(Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(toList());
    }
    public void save(PostRequest postRequest, User user) {
        postRepository.save(postMapper.map(postRequest, user));
    }
}
