package com.fiap.postech.techchallenge.fastfoodnotification.application.amqp;

import com.fiap.postech.techchallenge.fastfoodnotification.application.amqp.records.DadosNotificacao;
import com.fiap.postech.techchallenge.fastfoodnotification.application.config.NotificacaoConfiguration;
import com.fiap.postech.techchallenge.fastfoodnotification.application.service.NotificacaoEmail;
import com.fiap.postech.techchallenge.fastfoodnotification.application.service.NotificacaoHelper;
import com.fiap.postech.techchallenge.fastfoodnotification.application.service.NotificacaoMonitor;
import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.Notificacao;
import com.fiap.postech.techchallenge.fastfoodnotification.infra.smtp.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NotificacaoListenerTest {

    @Mock
    private NotificacaoConfiguration notificacaoConfiguration;

    @Mock
    private NotificacaoMonitor notificacaoMonitor;

    @Mock
    private NotificacaoEmail notificacaoEmail;

    @InjectMocks
    private NotificacaoListener notificacaoListener;

    @Test
    public void deveNotificarViaEmail(){
        DadosNotificacao dadosNotificacao = NotificacaoHelper.criarDadosNotificacaoComEmail();

        Mockito.when(notificacaoConfiguration.notificacaoProvider(dadosNotificacao.getEmail()))
                .thenReturn(notificacaoEmail);


        notificacaoListener.notificar(dadosNotificacao);

        Mockito.verify(notificacaoEmail, Mockito.times(1))
                .notificar(Mockito.any(Notificacao.class));
    }

    @Test
    public void deveNotificarViaMonitor(){
        DadosNotificacao dadosNotificacao = NotificacaoHelper.criarDadosNotificacaoComEmail();
        dadosNotificacao.setEmail(null);

        Mockito.when(notificacaoConfiguration.notificacaoProvider(dadosNotificacao.getEmail()))
                .thenReturn(notificacaoMonitor);


        notificacaoListener.notificar(dadosNotificacao);

        Mockito.verify(notificacaoMonitor, Mockito.times(1))
                .notificar(Mockito.any(Notificacao.class));
    }

}