package com.fiap.postech.techchallenge.fastfoodnotification.application.service;


import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.Notificacao;
import com.fiap.postech.techchallenge.fastfoodnotification.infra.smtp.EmailService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class NotificacaoEmailTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private NotificacaoEmail notificacaoEmail;

    @Test
    public void deveNotificarPorEmail(){

        Mockito.doNothing()
                .when(emailService).enviarEmail(Mockito.any(), Mockito.any(), Mockito.any());

        Notificacao notificacao = NotificacaoHelper.criarNotificacao();
        notificacaoEmail.notificar(notificacao);

        Mockito.verify(emailService, Mockito.times(1))
                .enviarEmail(Mockito.any(), Mockito.any(), Mockito.any());

    }

}