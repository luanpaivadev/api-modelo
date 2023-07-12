package com.luanpaiva.examplejunittest.core.model.enums;

public enum Bandeira {

    MASTERCARD("Mastercard"),
    VISA("Visa"),
    ELO("Elo"),
    AMERICAN_EXPRESS("American Express"),
    HIPERCARD("Hipercard");

    private final String descricao;

    Bandeira(String descricao) {
        this.descricao = descricao;
    }
}
