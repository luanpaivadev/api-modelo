package com.luanpaiva.examplejunittest.core.service;

import com.luanpaiva.examplejunittest.core.model.Estoque;
import com.luanpaiva.examplejunittest.core.port.repository.EstoqueRepositoryPort;
import com.luanpaiva.examplejunittest.core.port.service.EstoqueServicePort;

public class EstoqueService implements EstoqueServicePort {

    private final EstoqueRepositoryPort estoqueRepositoryPort;

    public EstoqueService(EstoqueRepositoryPort estoqueRepositoryPort) {
        this.estoqueRepositoryPort = estoqueRepositoryPort;
    }

    @Override
    public Estoque save(Estoque estoque) {
        return estoqueRepositoryPort.save(estoque);
    }
}
