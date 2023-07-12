package com.luanpaiva.examplejunittest.core.port.service;

import com.luanpaiva.examplejunittest.core.model.Produto;

public interface ProdutoServicePort {

    Produto save(Produto produto);
    Produto findById(Long id);
}
