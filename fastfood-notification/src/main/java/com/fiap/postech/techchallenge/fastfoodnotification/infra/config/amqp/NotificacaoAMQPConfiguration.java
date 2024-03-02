package com.fiap.postech.techchallenge.fastfoodnotification.infra.config.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoAMQPConfiguration {

    public static final String NOTIFICACAO_EX = "ex.notificacao";
    public static final String NOTIFICACAO_QUEUE = "queue.notificacao";
    public static final String NOTIFICACAO_DLX = "dlx.notificacao";
    public static final String NOTIFICACAO_DLQ = "dlq.notificacao";


    @Bean
    public RabbitAdmin criarAdminConfig(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> startAdmin(RabbitAdmin rabbitAdmin){
        return  event -> rabbitAdmin.initialize();
    }

    @Bean
        public Jackson2JsonMessageConverter messageConverter(){
            return new Jackson2JsonMessageConverter();
        }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter converter){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter);

        return rabbitTemplate;
    }


    @Bean
    public Queue notificacaoQueue(){
        return QueueBuilder.nonDurable(NOTIFICACAO_QUEUE)
                .deadLetterExchange(NOTIFICACAO_DLX)
                .build();
    }

    @Bean
    public FanoutExchange notificacaoExchange(){
        return new FanoutExchange(NOTIFICACAO_EX);
    }


    @Bean
    public Binding notificacaoBinding(){
        return BindingBuilder.bind(notificacaoQueue()).to(notificacaoExchange());

    }

    @Bean
    public FanoutExchange notificacaoDLX(){
        return new FanoutExchange(NOTIFICACAO_DLX);
    }


    @Bean
    public Queue notificacaoDLQ(){
        return QueueBuilder.nonDurable(NOTIFICACAO_DLQ)
                .build();
    }

    @Bean
    public Binding notificacaoDLXDLQBinding(){
        return BindingBuilder.bind(notificacaoDLQ()).to(notificacaoDLX());

    }

}
