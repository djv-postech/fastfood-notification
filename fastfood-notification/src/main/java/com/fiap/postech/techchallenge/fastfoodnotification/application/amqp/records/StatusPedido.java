package com.fiap.postech.techchallenge.fastfoodnotification.application.amqp.records;

public enum StatusPedido {

    PRONTO("pronto"),
    EM_PREPARACAO("em preparação"),
    RECEBIDO("recebido"),
    FINALIZADO("finalizado");


    private final String value;

    StatusPedido(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
