package com.singular.blogapijava.controller;

import com.singular.blogapijava.dto.PostDTO;
import com.singular.blogapijava.exception.UserNotFoundException;
import com.singular.blogapijava.model.Post;
import com.singular.blogapijava.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController()
@RequestMapping("/blog")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Object> getPostById(@PathVariable String id) {
        Post response = postService.getPostById(id);

        if (Objects.isNull(response)) {
            return ResponseEntity.status(404).body("Post não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> savePost(@RequestBody PostDTO postDTO) throws UserNotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(postDTO));
    }
}
