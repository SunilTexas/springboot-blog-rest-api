package com.springboot.blog.service.Imp;

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.mapper.MapEntityToDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImp implements PostService {

    private PostRepository postRepository;
    private MapEntityToDto mapEntityToDto;

    public PostServiceImp(PostRepository postRepository, MapEntityToDto mapEntityToDto){
        this.postRepository = postRepository;
        this.mapEntityToDto = mapEntityToDto;
    }

    @Override
    public PostDto createPost(PostDto dto) {
        //convert DTO to Entity
        Post entity = mapEntityToDto.MapDtoToEntity(dto);
        Post savedEntity = postRepository.save(entity);
        //convert Entity to DTO
        PostDto  savedDto = mapEntityToDto.MapEntityToDto(savedEntity);
        return savedDto;
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> entityList = postRepository.findAll();
        List<PostDto> dtoList = new ArrayList<>();
        for (Post post:entityList) {
            PostDto postDto = mapEntityToDto.MapEntityToDto(post);
            dtoList.add(postDto);
        }
        return dtoList;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("", "", id));
        return mapEntityToDto.MapEntityToDto(post);
    }

}
