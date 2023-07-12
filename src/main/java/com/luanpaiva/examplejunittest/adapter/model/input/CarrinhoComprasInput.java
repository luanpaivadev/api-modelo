package com.luanpaiva.examplejunittest.adapter.model.input;

import lombok.Data;

import java.util.List;

@Data
public class CarrinhoComprasInput {
    private List<ItemCarrinhoComprasInput> itens;
}
