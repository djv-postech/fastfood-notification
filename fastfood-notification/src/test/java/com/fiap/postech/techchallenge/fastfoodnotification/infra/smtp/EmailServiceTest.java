package com.fiap.postech.techchallenge.fastfoodnotification.infra.smtp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private EmailService emailService;


    @Test
    public void deveEfetuarEnvioDeEmail(){
        var para = "teste";
        var assunto = "status pedido x";
        var corpo = "seu pedido está com status";

        Mockito.doNothing().when(javaMailSender).send(Mockito.any(SimpleMailMessage.class));

        emailService.enviarEmail(para, assunto, corpo);

        Mockito.verify(javaMailSender, Mockito.times(1))
                .send(Mockito.any(SimpleMailMessage.class));

    }

}