package com.luanpaiva.examplejunittest.adapter.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EstoqueDto {
    private Long id;
    private Integer quantidade;
    @JsonProperty("produto")
    private String produtoDescricao;
}
