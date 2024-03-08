package com.fiap.postech.techchallenge.fastfoodnotification.application.service;

import com.fiap.postech.techchallenge.fastfoodnotification.application.amqp.records.DadosNotificacao;
import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.Notificacao;

public class NotificacaoHelper {

    public static Notificacao criarNotificacao() {
        return new Notificacao("Teste", "teste@teste.com", "texto");
    }

    public static DadosNotificacao criarDadosNotificacaoComEmail() {
        return new DadosNotificacao("teste", "teste@teste", "teste");
    }
}
