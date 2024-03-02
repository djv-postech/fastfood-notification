package com.fiap.postech.techchallenge.fastfoodnotification.application.amqp;

import com.fiap.postech.techchallenge.fastfoodnotification.application.records.DadosNotificacao;
import com.fiap.postech.techchallenge.fastfoodnotification.domain.usecases.notificacao.NotificacaoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.fiap.postech.techchallenge.fastfoodnotification.infra.config.amqp.NotificacaoAMQPConfiguration.NOTIFICACAO_QUEUE;

@Component
public class NotificacaoListener {

    private final NotificacaoService notificacaoService;

    public NotificacaoListener(NotificacaoService notificacaoService) {
        this.notificacaoService = notificacaoService;
    }

    @RabbitListener(queues = NOTIFICACAO_QUEUE)
    public void notificar(DadosNotificacao notificacao){
          notificacaoService.notificar(notificacao);
    }
}
