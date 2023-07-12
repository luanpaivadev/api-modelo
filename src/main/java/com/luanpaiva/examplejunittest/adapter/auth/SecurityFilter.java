package com.luanpaiva.examplejunittest.adapter.auth;

import com.luanpaiva.examplejunittest.adapter.output.UsuarioRepository;
import com.luanpaiva.examplejunittest.core.exceptions.UsuarioNaoEncontradoException;
import com.luanpaiva.examplejunittest.core.model.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@AllArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION = "Authorization";
    private static final String BEARER = "Bearer ";
    private static final String E_MAIL_OU_SENHA_INVALIDOS = "E-mail ou senha inválidos.";

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        String tokenJWT = getToken(request);
        if (Objects.nonNull(tokenJWT)) {
            String subject = tokenService.validarToken(tokenJWT);
            Usuario usuario = usuarioRepository.findByEmail(subject)
                    .orElseThrow(() -> new UsuarioNaoEncontradoException(E_MAIL_OU_SENHA_INVALIDOS));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String tokenJWT = request.getHeader(AUTHORIZATION);
        if (Objects.nonNull(tokenJWT)) {
            return tokenJWT.replace(BEARER, "");
        }
        return null;
    }

}
