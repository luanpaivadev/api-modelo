package com.luanpaiva.examplejunittest.core.port.repository;

import com.luanpaiva.examplejunittest.core.model.Produto;

import java.util.Optional;

public interface ProdutoRepositoryPort {

    Produto save(Produto produto);
    Optional<Produto> findById(Long id);
}
