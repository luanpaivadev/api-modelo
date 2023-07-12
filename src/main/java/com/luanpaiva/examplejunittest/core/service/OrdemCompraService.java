package com.luanpaiva.examplejunittest.core.service;

import com.luanpaiva.examplejunittest.core.model.OrdemCompra;
import com.luanpaiva.examplejunittest.core.port.repository.OrdemCompraRepositoryPort;
import com.luanpaiva.examplejunittest.core.port.service.OrdemCompraServicePort;

public class OrdemCompraService implements OrdemCompraServicePort {

    private final OrdemCompraRepositoryPort ordemCompraRepositoryPort;

    public OrdemCompraService(OrdemCompraRepositoryPort ordemCompraRepositoryPort) {
        this.ordemCompraRepositoryPort = ordemCompraRepositoryPort;
    }

    @Override
    public OrdemCompra save(OrdemCompra ordemCompra) {
        return ordemCompraRepositoryPort.save(ordemCompra);
    }
}
