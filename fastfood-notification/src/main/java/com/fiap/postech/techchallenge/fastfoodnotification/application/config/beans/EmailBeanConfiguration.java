package com.fiap.postech.techchallenge.fastfoodnotification.application.config.beans;

import com.fiap.postech.techchallenge.fastfoodnotification.infra.smtp.EmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;


@Configuration
public class EmailBeanConfiguration {

    private final JavaMailSender javaMailSender;

    public EmailBeanConfiguration(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Bean
    public EmailService email(){
        return new EmailService(javaMailSender);
    }
}
