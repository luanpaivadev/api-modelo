package com.luanpaiva.examplejunittest.adapter.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class ClienteInput {

    @NotNull
    private String nome;
    @NotNull
    private String cpf;
    @NotNull
    private String email;
    @NotNull
    private String telefone;
    private List<EnderecoInput> enderecos;
    private List<CartaoInput> cartoes;
}
