package com.luanpaiva.examplejunittest.adapter.input.api.v1;

import com.luanpaiva.examplejunittest.adapter.model.dto.ClienteDto;
import com.luanpaiva.examplejunittest.adapter.model.input.ClienteInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Clientes", description = "Responsável por gerenciar o cadastro de clientes.")
public interface IClienteController {

    @Operation(summary = "Salva um cliente", description = "Responsável por salvar um cliente")
    ResponseEntity<ClienteDto> save(@RequestBody(description = "Representação de um novo cliente", required = true) ClienteInput clienteInput);

    @Operation(summary = "Lista os clientes", description = "Responsável por listar todos os clientes cadastrados")
    ResponseEntity<List<ClienteDto>> findAll();

    @Operation(summary = "Busca um cliente pelo ID", description = "Responsável por retornar um cliente cadastrado pelo ID")
    ResponseEntity<ClienteDto> findById(@Parameter(description = "ID do cliente", example = "1", required = true) Long id);
}
