package com.luanpaiva.examplejunittest.core.service;

import com.luanpaiva.examplejunittest.core.exceptions.ProdutoNaoEncontradoException;
import com.luanpaiva.examplejunittest.core.model.Produto;
import com.luanpaiva.examplejunittest.core.port.repository.ProdutoRepositoryPort;
import com.luanpaiva.examplejunittest.core.port.service.ProdutoServicePort;

import static java.text.MessageFormat.format;

public class ProdutoService implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ProdutoService(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public Produto save(Produto produto) {
        return produtoRepositoryPort.save(produto);
    }

    @Override
    public Produto findById(Long id) {
        return produtoRepositoryPort.findById(id)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(format("Produto com id {0}, não encontrado.", id)));
    }
}
