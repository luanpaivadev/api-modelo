package com.luanpaiva.examplejunittest.core.service;

import com.luanpaiva.examplejunittest.core.exceptions.UsuarioNaoEncontradoException;
import com.luanpaiva.examplejunittest.core.model.Usuario;
import com.luanpaiva.examplejunittest.core.port.repository.UsuarioRepositoryPort;
import com.luanpaiva.examplejunittest.core.port.service.UsuarioServicePort;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepositoryPort.save(usuario);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepositoryPort.findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("E-mail ou senha inválidos."));
    }
}
