package com.singular.blogapijava.mapper;

import com.singular.blogapijava.dto.PostDTO;
import com.singular.blogapijava.model.Post;

public class PostMapper {

    public static Post from (PostDTO dto) {
        Post post = new Post();
        post.setTitulo(dto.getTitulo());
        post.setConteudo(dto.getConteudo());
        post.setImgagemUrl(dto.getImgagemUrl());
        return post;
    }

}
