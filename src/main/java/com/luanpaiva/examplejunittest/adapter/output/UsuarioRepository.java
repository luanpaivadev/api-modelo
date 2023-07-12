package com.luanpaiva.examplejunittest.adapter.output;

import com.luanpaiva.examplejunittest.adapter.model.UsuarioEntity;
import com.luanpaiva.examplejunittest.adapter.output.repository.UsuarioRepositoryJpa;
import com.luanpaiva.examplejunittest.core.model.Usuario;
import com.luanpaiva.examplejunittest.core.port.repository.UsuarioRepositoryPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UsuarioRepository implements UsuarioRepositoryPort {

    private final UsuarioRepositoryJpa usuarioRepositoryJpa;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        UsuarioEntity usuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);
        usuarioEntity = usuarioRepositoryJpa.save(usuarioEntity);
        return modelMapper.map(usuarioEntity, Usuario.class);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        Optional<UsuarioEntity> optionalUsuarioEntity = usuarioRepositoryJpa.findByEmail(email);
        return optionalUsuarioEntity.map(usuarioEntity -> modelMapper.map(usuarioEntity, Usuario.class));
    }
}
