package com.luanpaiva.examplejunittest.core.port.repository;

import com.luanpaiva.examplejunittest.core.model.Usuario;

import java.util.Optional;

public interface UsuarioRepositoryPort {

    Usuario save(Usuario usuario);
    Optional<Usuario> findByEmail(String email);
}
