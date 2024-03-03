package com.fiap.postech.techchallenge.fastfoodnotification.application.config.beans;

import com.fiap.postech.techchallenge.fastfoodnotification.infra.smtp.EmailService;
import com.fiap.postech.techchallenge.fastfoodnotification.application.service.NotificacaoEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoBeanConfiguration {

    private final EmailService emailService;

    public NotificacaoBeanConfiguration(EmailService emailService) {
        this.emailService = emailService;
    }

    @Bean
    public NotificacaoEmail notificacao() {
        return new NotificacaoEmail(emailService);
    }


}
