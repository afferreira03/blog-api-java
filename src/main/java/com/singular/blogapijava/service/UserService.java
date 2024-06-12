package com.singular.blogapijava.service;

import com.singular.blogapijava.dto.UserDTO;
import com.singular.blogapijava.mapper.UserMapper;
import com.singular.blogapijava.model.User;
import com.singular.blogapijava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
