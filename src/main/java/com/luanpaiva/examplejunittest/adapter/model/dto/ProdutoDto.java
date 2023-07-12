package com.luanpaiva.examplejunittest.adapter.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDto {
    private Long id;
    private String descricao;
    private BigDecimal preco;
    private Double porcentagemDesconto;
}
