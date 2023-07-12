package com.luanpaiva.examplejunittest.adapter.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CarrinhoComprasDto {
    private Long id;
    private List<ItemCarrinhoComprasDto> itens;
    private BigDecimal valorTotal;
}
