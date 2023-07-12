package com.luanpaiva.examplejunittest.adapter.config.mapper;

import com.luanpaiva.examplejunittest.adapter.model.input.ClienteInput;
import com.luanpaiva.examplejunittest.core.model.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClienteDisassembler implements MapperToDomainObject<ClienteInput, Cliente> {

    private final ModelMapper modelMapper;

    @Override
    public Cliente toDomainObject(ClienteInput clienteInput) {
        return modelMapper.map(clienteInput, Cliente.class);
    }

    @Override
    public List<Cliente> toDomainObjectList(List<ClienteInput> clienteInputList) {
        return clienteInputList.stream().map(clienteInput -> modelMapper.map(clienteInput, Cliente.class)).toList();
    }
}
