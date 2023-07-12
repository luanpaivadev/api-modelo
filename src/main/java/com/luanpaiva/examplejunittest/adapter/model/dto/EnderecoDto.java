package com.luanpaiva.examplejunittest.adapter.model.dto;

import lombok.Data;

@Data
public class EnderecoDto {
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String localidade;
    private String bairro;
    private String uf;
}
