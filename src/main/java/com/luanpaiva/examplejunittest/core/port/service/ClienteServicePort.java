package com.luanpaiva.examplejunittest.core.port.service;

import com.luanpaiva.examplejunittest.core.model.Cliente;

import java.util.List;

public interface ClienteServicePort {

    Cliente save(Cliente cliente);
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente findByEmail(String email);
}
