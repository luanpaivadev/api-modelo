package com.luanpaiva.examplejunittest.adapter.output;

import com.luanpaiva.examplejunittest.adapter.model.ProdutoEntity;
import com.luanpaiva.examplejunittest.adapter.output.repository.ProdutoRepositoryJpa;
import com.luanpaiva.examplejunittest.core.model.Produto;
import com.luanpaiva.examplejunittest.core.port.repository.ProdutoRepositoryPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProdutoRepository implements ProdutoRepositoryPort {

    private final ProdutoRepositoryJpa produtoRepositoryJpa;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Produto save(Produto produto) {
        ProdutoEntity produtoEntity = modelMapper.map(produto, ProdutoEntity.class);
        produtoEntity = produtoRepositoryJpa.save(produtoEntity);
        return modelMapper.map(produtoEntity, Produto.class);
    }

    @Override
    public Optional<Produto> findById(Long id) {
        Optional<ProdutoEntity> produtoEntityOptional = produtoRepositoryJpa.findById(id);
        return produtoEntityOptional.map(produtoEntity -> modelMapper.map(produtoEntity, Produto.class));
    }
}
