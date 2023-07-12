package com.luanpaiva.examplejunittest.core.model.enums;

public enum FormaPagamento {

    BOLETO("1"),
    PIX("2"),
    CARTAO_CREDITO("3"),
    CARTAO_DEBITO("4");

    private final String codigo;

    FormaPagamento(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
