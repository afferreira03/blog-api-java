package com.singular.blogapijava.service;

import com.singular.blogapijava.dto.AuthenticationRequestDTO;
import com.singular.blogapijava.dto.UserDTO;
import com.singular.blogapijava.model.User;
import com.singular.blogapijava.util.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtil jwtUtil;

    public AuthService(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, UserService userService, PasswordEncoder passwordEncoder, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public String registerUser(UserDTO userDTO) {
        userDTO.setSenha(passwordEncoder.encode(userDTO.getSenha()));
        User user = userService.saveUser(userDTO);
        return user.toString();
    }

    public String loginUser(AuthenticationRequestDTO dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));
        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(dto.getUsername());
        return jwtUtil.generateToken(userDetails);
    }
}
