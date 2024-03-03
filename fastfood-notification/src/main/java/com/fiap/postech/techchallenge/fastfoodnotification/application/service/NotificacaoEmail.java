package com.fiap.postech.techchallenge.fastfoodnotification.application.service;

import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.Notificacao;
import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.NotificacaoI;
import com.fiap.postech.techchallenge.fastfoodnotification.infra.smtp.EmailService;

public class NotificacaoEmail implements NotificacaoI {

    public static final String PEDIDO_FASTFOOD_POSTECH = "Pedido Fastfood Postech";
    private final EmailService emailService;

    public NotificacaoEmail(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notificar(Notificacao notificacao) {
       emailService.enviarEmail(notificacao.getEmail(),
               PEDIDO_FASTFOOD_POSTECH, notificacao.getTexto());
    }
}
