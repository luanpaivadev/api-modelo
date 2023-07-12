package com.luanpaiva.examplejunittest.adapter.output;

import com.luanpaiva.examplejunittest.adapter.model.ClienteEntity;
import com.luanpaiva.examplejunittest.adapter.output.repository.ClienteRepositoryJpa;
import com.luanpaiva.examplejunittest.core.model.Cliente;
import com.luanpaiva.examplejunittest.core.port.repository.ClienteRepositoryPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ClienteRepository implements ClienteRepositoryPort {

    private ClienteRepositoryJpa clienteRepositoryJpa;
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        final ClienteEntity clienteEntity = modelMapper.map(cliente, ClienteEntity.class);
        clienteEntity.getEnderecos().forEach(enderecoEntity -> enderecoEntity.setCliente(clienteEntity));
        clienteEntity.getCartoes().forEach(cartaoEntity -> cartaoEntity.setCliente(clienteEntity));
        return modelMapper.map(clienteRepositoryJpa.save(clienteEntity), Cliente.class);
    }

    @Override
    public List<Cliente> findAll() {
        List<ClienteEntity> clientes = clienteRepositoryJpa.findAll();
        return clientes.stream().map(cliente -> modelMapper.map(cliente, Cliente.class)).toList();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        Optional<ClienteEntity> optionalCliente = clienteRepositoryJpa.findById(id);
        return optionalCliente.map(clienteEntity -> modelMapper.map(clienteEntity, Cliente.class));
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {
        Optional<ClienteEntity> clienteEntityOptional = clienteRepositoryJpa.findByEmail(email);
        return clienteEntityOptional.map(clienteEntity -> modelMapper.map(clienteEntity, Cliente.class));
    }
}
