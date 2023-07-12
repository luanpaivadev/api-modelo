package com.luanpaiva.examplejunittest.adapter.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemCarrinhoComprasDto {
    private Long id;
    @JsonProperty("produto")
    private String produtoDescricao;
    private Integer quantidade;
}
