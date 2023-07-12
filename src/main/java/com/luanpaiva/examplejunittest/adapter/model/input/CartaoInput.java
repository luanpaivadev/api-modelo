package com.luanpaiva.examplejunittest.adapter.model.input;

import com.luanpaiva.examplejunittest.core.model.enums.Bandeira;
import lombok.Data;

@Data
public class CartaoInput {
    private Bandeira bandeira;
    private String numero;
    private String validade;
    private String cvv;
}
