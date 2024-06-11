package com.singular.blogapijava.dto;

public class PostDTO {

    private String id;
    private String titulo;
    private String conteudo;
    private String imgagemUrl;
    private String autor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
