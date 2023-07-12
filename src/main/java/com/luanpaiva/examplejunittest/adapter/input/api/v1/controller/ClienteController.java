package com.luanpaiva.examplejunittest.adapter.input.api.v1.controller;

import com.luanpaiva.examplejunittest.adapter.config.mapper.ClienteAssembler;
import com.luanpaiva.examplejunittest.adapter.config.mapper.ClienteDisassembler;
import com.luanpaiva.examplejunittest.adapter.input.api.v1.IClienteController;
import com.luanpaiva.examplejunittest.adapter.model.dto.ClienteDto;
import com.luanpaiva.examplejunittest.adapter.model.input.ClienteInput;
import com.luanpaiva.examplejunittest.core.model.Cliente;
import com.luanpaiva.examplejunittest.core.port.service.ClienteServicePort;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.luanpaiva.examplejunittest.core.constant.Roles.ROLE_ADMIN;
import static com.luanpaiva.examplejunittest.core.constant.Roles.ROLE_USER;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/clientes")
public class ClienteController implements IClienteController {

    private final ClienteServicePort clienteServicePort;
    private final ClienteAssembler clienteAssembler;
    private final ClienteDisassembler clienteDisassembler;

    @Override
    @PostMapping
    @Secured(ROLE_ADMIN)
    public ResponseEntity<ClienteDto> save(@RequestBody @Valid ClienteInput clienteInput) {
        Cliente cliente = clienteDisassembler.toDomainObject(clienteInput);
        cliente = clienteServicePort.save(cliente);
        ClienteDto clienteDto = clienteAssembler.toDtoObject(cliente);
        return ResponseEntity.ok(clienteDto);
    }

    @Override
    @GetMapping
    @Secured(ROLE_USER)
    public ResponseEntity<List<ClienteDto>> findAll() {
        List<Cliente> clientes = clienteServicePort.findAll();
        List<ClienteDto> clientesDtoList = clienteAssembler.toDtoObjectList(clientes);
        return ResponseEntity.ok(clientesDtoList);
    }

    @Override
    @GetMapping("/{id}")
    @Secured(ROLE_USER)
    public ResponseEntity<ClienteDto> findById(@PathVariable Long id) {
        Cliente cliente = clienteServicePort.findById(id);
        ClienteDto clienteDto = clienteAssembler.toDtoObject(cliente);
        return ResponseEntity.ok(clienteDto);
    }

}
