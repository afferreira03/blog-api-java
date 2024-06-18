package com.singular.blogapijava.service;

import com.singular.blogapijava.dto.PostDTO;
import com.singular.blogapijava.exception.UserNotFoundException;
import com.singular.blogapijava.mapper.PostMapper;
import com.singular.blogapijava.model.Post;
import com.singular.blogapijava.model.User;
import com.singular.blogapijava.repository.PostRepository;
import com.singular.blogapijava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserService userService
            ;
    @Autowired
    public PostService(PostRepository postRepository,UserService userService, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    public Post savePost(PostDTO postDTO) throws UserNotFoundException {
        Post post = PostMapper.from(postDTO);

        User autor = userService.getUserById(postDTO.getAutor());

        if (Objects.isNull(autor)) {
            throw new UserNotFoundException("Usuário não cadastrado.");
        }

        post.setUserId(autor.getId());
        post.setDataCriacao(LocalDateTime.now());

        Post response = postRepository.save(post);

        userService.addPostToUserById(post, postDTO.getAutor());

        return response;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }
}
