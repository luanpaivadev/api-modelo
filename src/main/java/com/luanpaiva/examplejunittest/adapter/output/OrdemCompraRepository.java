package com.luanpaiva.examplejunittest.adapter.output;

import com.luanpaiva.examplejunittest.adapter.model.OrdemCompraEntity;
import com.luanpaiva.examplejunittest.adapter.output.repository.OrdemCompraRepositoryJpa;
import com.luanpaiva.examplejunittest.core.model.OrdemCompra;
import com.luanpaiva.examplejunittest.core.port.repository.OrdemCompraRepositoryPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class OrdemCompraRepository implements OrdemCompraRepositoryPort {

    private final OrdemCompraRepositoryJpa ordemCompraRepositoryJpa;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public OrdemCompra save(OrdemCompra ordemCompra) {
        OrdemCompraEntity compraEntity = modelMapper.map(ordemCompra, OrdemCompraEntity.class);
        compraEntity = ordemCompraRepositoryJpa.save(compraEntity);
        return modelMapper.map(compraEntity, OrdemCompra.class);
    }
}
