package com.luanpaiva.examplejunittest.adapter.model.input;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoInput {
    private String descricao;
    private BigDecimal preco;
    private Double porcentagemDesconto;
}
