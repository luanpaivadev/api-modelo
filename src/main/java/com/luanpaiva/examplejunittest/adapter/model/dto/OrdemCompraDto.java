package com.luanpaiva.examplejunittest.adapter.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.luanpaiva.examplejunittest.core.model.enums.FormaPagamento;
import lombok.Data;

@Data
public class OrdemCompraDto {
    private Long id;
    @JsonProperty("cliente")
    private String clienteNome;
    private CarrinhoComprasDto carrinhoCompras;
    private FormaPagamento formaPagamento;
    private EnderecoDto enderecoEntrega;
}
