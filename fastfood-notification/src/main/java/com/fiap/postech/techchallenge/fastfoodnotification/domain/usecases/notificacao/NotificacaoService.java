package com.fiap.postech.techchallenge.fastfoodnotification.domain.usecases.notificacao;

import com.fiap.postech.techchallenge.fastfoodnotification.application.records.DadosNotificacao;

public class NotificacaoService {

    private EmailService emailService;

    public NotificacaoService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void notificar(DadosNotificacao notificacao) {
       emailService.enviarEmail(notificacao.getEmail(), "Pedido Fastfood", corpoEmail(notificacao));
    }

    private String corpoEmail(DadosNotificacao notificacao) {
        return notificacao.getNome() + " seu pedido: " + notificacao.getNumeroPedido()
                + " está: " + notificacao.getStatusPedido();
    }
}
