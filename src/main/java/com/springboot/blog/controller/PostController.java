package com.springboot.blog.controller;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.service.PostService;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    private PostService postService;

    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
        PostDto responsePost = postService.createPost(postDto);
        return new ResponseEntity<>(responsePost, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAll() {
        List<PostDto> list = postService.getAllPost();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") long id){
        PostDto responsePost = postService.getPostById(id);
        return new ResponseEntity<>(responsePost, HttpStatus.OK);
        //
    }


}

