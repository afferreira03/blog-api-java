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
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;
    private UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post savePost(PostDTO postDTO) throws UserNotFoundException {
        Post post = PostMapper.from(postDTO);

        Optional<User> autor = userRepository.findById(postDTO.getAutor());
        if (autor.isEmpty()) {
            throw new UserNotFoundException("Usuário não cadastrado.");
        }

        post.setAutor(autor.get());
        post.setDataCriacao(LocalDateTime.now());

        return postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElse(null);
    }
}
