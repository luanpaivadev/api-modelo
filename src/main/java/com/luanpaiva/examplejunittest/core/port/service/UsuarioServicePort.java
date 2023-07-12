package com.luanpaiva.examplejunittest.core.port.service;

import com.luanpaiva.examplejunittest.core.model.Usuario;

public interface UsuarioServicePort {

    Usuario save(Usuario usuario);

    Usuario findByEmail(String email);
}
