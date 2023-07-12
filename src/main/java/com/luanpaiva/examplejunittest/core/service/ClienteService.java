package com.luanpaiva.examplejunittest.core.service;

import com.luanpaiva.examplejunittest.core.exceptions.ClienteNaoEncontradoException;
import com.luanpaiva.examplejunittest.core.model.Cartao;
import com.luanpaiva.examplejunittest.core.model.Cliente;
import com.luanpaiva.examplejunittest.core.port.repository.ClienteRepositoryPort;
import com.luanpaiva.examplejunittest.core.port.service.ClienteServicePort;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static java.text.MessageFormat.format;

@Slf4j
public class ClienteService implements ClienteServicePort {

    private static final String CLIENTE_SALVO_COM_SUCESSO = "Cliente salvo com sucesso.";

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteService(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente save(Cliente cliente) {
        cliente.getCartoes().forEach(this::ofuscarNumeroCartao);
        cliente = clienteRepositoryPort.save(cliente);

        log.info(CLIENTE_SALVO_COM_SUCESSO);
        return cliente;
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepositoryPort.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepositoryPort.findById(id)
                .orElseThrow(() -> new ClienteNaoEncontradoException(format("Cliente com id {0}, não encontrado.", id)));
    }

    @Override
    public Cliente findByEmail(String email) {
        return clienteRepositoryPort.findByEmail(email)
                .orElseThrow(() -> new ClienteNaoEncontradoException(format("Cliente com email {0}, não encontrado.", email)));
    }

    private void ofuscarNumeroCartao(Cartao cartao) {
        String numeroCartao = cartao.getNumero();
        String parte1 = numeroCartao.substring(0, 4);
        String parte4 = numeroCartao.substring(12, 16);
        cartao.setNumero(parte1 + "********" + parte4);
    }
}
