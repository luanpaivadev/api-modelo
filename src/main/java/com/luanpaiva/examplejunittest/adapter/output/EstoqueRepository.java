package com.luanpaiva.examplejunittest.adapter.output;

import com.luanpaiva.examplejunittest.adapter.model.EstoqueEntity;
import com.luanpaiva.examplejunittest.adapter.output.repository.EstoqueRepositoryJpa;
import com.luanpaiva.examplejunittest.core.model.Estoque;
import com.luanpaiva.examplejunittest.core.port.repository.EstoqueRepositoryPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class EstoqueRepository implements EstoqueRepositoryPort {

    private final EstoqueRepositoryJpa estoqueRepositoryJpa;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Estoque save(Estoque estoque) {
        EstoqueEntity estoqueEntity = modelMapper.map(estoque, EstoqueEntity.class);
        estoqueEntity = estoqueRepositoryJpa.save(estoqueEntity);
        return modelMapper.map(estoqueEntity, Estoque.class);
    }
}
