package com.singular.blogapijava.service;

import com.singular.blogapijava.dto.UserDTO;
import com.singular.blogapijava.exception.UserNotFoundException;
import com.singular.blogapijava.mapper.UserMapper;
import com.singular.blogapijava.model.Post;
import com.singular.blogapijava.model.User;
import com.singular.blogapijava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(UserDTO userDto) {
        User user = UserMapper.from(userDto);
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        Optional<User> response = userRepository.findById(id);
        return response.orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addPostToUserById(Post post, String id) throws UserNotFoundException {
        Optional<User> autorOptional = userRepository.findById(id);

        if(autorOptional.isEmpty()) {
            throw new UserNotFoundException("Usuario não encontrado");
        }

        User autor = autorOptional.get();

        if(Objects.isNull(autor.getPosts())){
            List<Post> posts = new ArrayList<>();
            posts.add(post);
            autor.setPosts(posts);
        } else {
            autor.getPosts().add(post);
        }

        userRepository.save(autor);
    }
}
