package com.fiap.postech.techchallenge.fastfoodnotification.application.records;


public class DadosNotificacao {

    private String numeroPedido;
    private String nome;
    private String email;
    private String statusPedido;
    private String statusPagamento;

    public DadosNotificacao(String numeroPedido, String nome, String email, String statusPedido, String statusPagamento) {
        this.numeroPedido = numeroPedido;
        this.nome = nome;
        this.email = email;
        this.statusPedido = statusPedido;
        this.statusPagamento = statusPagamento;
    }

    public DadosNotificacao(){

    }

    public void setNumeroPedido(String numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }
}
