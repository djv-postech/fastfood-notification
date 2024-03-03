package com.fiap.postech.techchallenge.fastfoodnotification.application.amqp;

import com.fiap.postech.techchallenge.fastfoodnotification.application.amqp.records.DadosNotificacao;
import com.fiap.postech.techchallenge.fastfoodnotification.application.config.NotificacaoConfiguration;
import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.NotificacaoI;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.fiap.postech.techchallenge.fastfoodnotification.infra.config.amqp.NotificacaoAMQPConfiguration.NOTIFICACAO_QUEUE;

@Component
public class NotificacaoListener {

    private NotificacaoI notificacaoI;
    private final NotificacaoConfiguration notificacaoConfiguration;

    public NotificacaoListener(NotificacaoI notificacaoI, NotificacaoConfiguration notificacaoConfiguration) {
        this.notificacaoI = notificacaoI;
        this.notificacaoConfiguration = notificacaoConfiguration;
    }

    @RabbitListener(queues = NOTIFICACAO_QUEUE)
    public void notificar(DadosNotificacao dadosNotificacao){

        notificacaoI = notificacaoConfiguration.notificacaoProvider(dadosNotificacao.getEmail());

        notificacaoI.notificar(dadosNotificacao.toNotificacao());
    }
}
