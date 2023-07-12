package com.luanpaiva.examplejunittest.adapter.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClienteDto {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private List<EnderecoDto> enderecos;
}
