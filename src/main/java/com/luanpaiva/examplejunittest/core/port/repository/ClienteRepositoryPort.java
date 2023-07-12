package com.luanpaiva.examplejunittest.core.port.repository;

import com.luanpaiva.examplejunittest.core.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositoryPort {

    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
    Optional<Cliente> findByEmail(String email);
}
