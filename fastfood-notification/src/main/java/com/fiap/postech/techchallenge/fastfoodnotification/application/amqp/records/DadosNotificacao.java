package com.fiap.postech.techchallenge.fastfoodnotification.application.amqp.records;

import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.Notificacao;

public class DadosNotificacao {

    private String nome;
    private String email;
    private String texto;


    public Notificacao toNotificacao() {
        return new Notificacao(nome, email, texto);
    }

    public String getNome() {
        return nome;
    }

    public String getTexto() {
        return texto;
    }

    public String getEmail() {
        return email;
    }
}
