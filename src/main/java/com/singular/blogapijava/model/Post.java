package com.singular.blogapijava.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Post {

    @Id
    private Long id;
    private String titulo;
    private String conteudo;
    private String imgagemUrl;
    @DBRef(db="User")
    private User autor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getImgagemUrl() {
        return imgagemUrl;
    }

    public void setImgagemUrl(String imgagemUrl) {
        this.imgagemUrl = imgagemUrl;
    }

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }
}
