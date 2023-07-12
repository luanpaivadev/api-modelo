package com.luanpaiva.examplejunittest.adapter.model.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.luanpaiva.examplejunittest.core.model.enums.FormaPagamento;
import lombok.Data;

@Data
public class OrdemCompraInput {
    private Long clienteId;
    @JsonProperty("carrinhoCompras")
    private CarrinhoComprasInput carrinhoComprasInput;
    private FormaPagamento formaPagamento;
    @JsonProperty("enderecoEntregaId")
    private Long enderecoId;
}
