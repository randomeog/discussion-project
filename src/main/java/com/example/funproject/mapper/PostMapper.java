package com.example.funproject.mapper;

import com.example.funproject.models.Post;
import com.example.funproject.models.User;
import com.example.funproject.request.PostRequest;
import com.example.funproject.request.PostResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "user", source = "user")
    @Mapping(target = "description", source = "postRequest.description")
    Post map(PostRequest postRequest, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "postName", source = "postName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);
}
