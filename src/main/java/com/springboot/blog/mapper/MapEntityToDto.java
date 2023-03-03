package com.springboot.blog.mapper;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class MapEntityToDto{

    public PostDto MapEntityToDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    public Post MapDtoToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
