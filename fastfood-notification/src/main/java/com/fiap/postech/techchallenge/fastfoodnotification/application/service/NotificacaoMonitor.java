package com.fiap.postech.techchallenge.fastfoodnotification.application.service;

import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.Notificacao;
import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.NotificacaoI;

public class NotificacaoMonitor implements NotificacaoI {

    @Override
    public void notificar(Notificacao notificacao) {
        System.out.println(notificacao.getTexto());
    }
}
