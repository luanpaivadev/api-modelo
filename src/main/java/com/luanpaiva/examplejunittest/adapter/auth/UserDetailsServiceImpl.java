package com.luanpaiva.examplejunittest.adapter.auth;

import com.luanpaiva.examplejunittest.core.port.repository.UsuarioRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return usuarioRepositoryPort.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado."));
    }
}
