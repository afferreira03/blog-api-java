package com.singular.blogapijava.mapper;

import com.singular.blogapijava.dto.UserDTO;
import com.singular.blogapijava.model.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserMapper {

    public static User from(UserDTO dto) {
        User user = new User();

        user.setAtivo(Boolean.TRUE);
        user.setEmail(dto.getEmail());
        user.setNome(dto.getNome());
        user.setSenha(dto.getSenha());
        user.setDataCadastro(LocalDate.now());
        user.setPosts(new ArrayList<>());

        return user;
    }
}
