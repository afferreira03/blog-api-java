package com.singular.blogapijava.controller;

import com.singular.blogapijava.dto.AuthenticationRequestDTO;
import com.singular.blogapijava.dto.UserDTO;
import com.singular.blogapijava.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Object> registerNewUser(@RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthenticationRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.loginUser(dto));
    }

}
