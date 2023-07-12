package com.luanpaiva.examplejunittest.adapter.config.mapper;

import com.luanpaiva.examplejunittest.adapter.model.dto.ClienteDto;
import com.luanpaiva.examplejunittest.core.model.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClienteAssembler implements MapperToDtoObject<Cliente, ClienteDto> {

    private final ModelMapper modelMapper;

    @Override
    public ClienteDto toDtoObject(Cliente cliente) {
        return modelMapper.map(cliente, ClienteDto.class);
    }

    @Override
    public List<ClienteDto> toDtoObjectList(List<Cliente> clientes) {
        return clientes.stream().map(cliente -> modelMapper.map(cliente, ClienteDto.class)).toList();
    }
}
