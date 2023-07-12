package com.luanpaiva.examplejunittest.adapter.model.input;

import lombok.Data;

@Data
public class EnderecoInput {
    private String cep;
    private String logradouro;
    private String complemento;
    private String localidade;
    private String bairro;
    private String uf;
}
