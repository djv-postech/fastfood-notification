package com.fiap.postech.techchallenge.fastfoodnotification.application.service;


import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.Notificacao;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificacaoMonitorTest {

    private final NotificacaoMonitor notificacaoMonitor = new NotificacaoMonitor();


    @Test
    public void shouldPrintNotification(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Notificacao notificacao = NotificacaoHelper.criarNotificacao();
        notificacaoMonitor.notificar(notificacao);

        String saidaConsole = outContent.toString().trim();

        assertEquals("texto", saidaConsole);

    }

}