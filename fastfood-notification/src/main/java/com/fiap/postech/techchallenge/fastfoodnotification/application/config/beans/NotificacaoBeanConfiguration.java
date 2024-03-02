package com.fiap.postech.techchallenge.fastfoodnotification.application.config.beans;

import com.fiap.postech.techchallenge.fastfoodnotification.domain.usecases.notificacao.EmailService;
import com.fiap.postech.techchallenge.fastfoodnotification.domain.usecases.notificacao.NotificacaoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class NotificacaoBeanConfiguration {

    private final EmailService emailService;

    public NotificacaoBeanConfiguration(EmailService emailService) {
        this.emailService = emailService;
    }

    @Bean
    public NotificacaoService notificacao() {
        return new NotificacaoService(emailService);
    }


}
