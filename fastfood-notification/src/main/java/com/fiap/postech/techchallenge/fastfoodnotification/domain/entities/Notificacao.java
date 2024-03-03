package com.fiap.postech.techchallenge.fastfoodnotification.domain.entities;


public class Notificacao {

    private final String nome;
    private final String email;
    private final String texto;

    public Notificacao(String nome, String email, String texto) {
        this.nome = nome;
        this.email = email;
        this.texto = texto;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTexto() {
        return texto;
    }
}
