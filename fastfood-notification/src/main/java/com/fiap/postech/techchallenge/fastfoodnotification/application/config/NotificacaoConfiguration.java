package com.fiap.postech.techchallenge.fastfoodnotification.application.config;

import com.fiap.postech.techchallenge.fastfoodnotification.application.service.NotificacaoEmail;
import com.fiap.postech.techchallenge.fastfoodnotification.application.service.NotificacaoMonitor;
import com.fiap.postech.techchallenge.fastfoodnotification.domain.entities.NotificacaoI;
import com.fiap.postech.techchallenge.fastfoodnotification.infra.smtp.EmailService;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoConfiguration {

    private final EmailService emailService;

    public NotificacaoConfiguration(EmailService emailService) {
        this.emailService = emailService;
    }

    public NotificacaoI notificacaoProvider(String email) {
        if (email != null && !email.isEmpty()) {
            return new NotificacaoEmail(emailService);
        } else {
            return new NotificacaoMonitor();
        }
    }
}
