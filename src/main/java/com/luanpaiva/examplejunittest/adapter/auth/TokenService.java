package com.luanpaiva.examplejunittest.adapter.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.luanpaiva.examplejunittest.core.exceptions.TokenInvalidoException;
import com.luanpaiva.examplejunittest.core.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TokenService {

    private static final int EXPIRATION_HOURS = 1;
    private static final String OFFSET_ID = "-03:00";
    private static final String CONTROLEASY_API = "Controleasy API";
    private static final String ERRO_AO_GERAR_TOKEN_JWT = "Erro ao gerar token JWT";
    private static final String TOKEN_JWT_INVALIDO_OU_EXPIRADO = "Token JWT inválido ou expirado!";

    private final TokenProperties properties;

    public String gerarToken(Usuario usuario) {

        try {
            return JWT.create()
                    .withIssuer(CONTROLEASY_API)
                    .withSubject(usuario.getEmail())
                    .withIssuedAt(issuedAt())
                    .withExpiresAt(expiresAt())
                    .withJWTId(UUID.randomUUID().toString())
                    .sign(Algorithm.HMAC256(properties.getSecret()));
        } catch (JWTCreationException e) {
            throw new TokenInvalidoException(ERRO_AO_GERAR_TOKEN_JWT);
        }
    }

    public String validarToken(String tokenJWT) {

        try {
            return JWT.require(Algorithm.HMAC256(properties.getSecret()))
                    .withIssuer(CONTROLEASY_API)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new TokenInvalidoException(TOKEN_JWT_INVALIDO_OU_EXPIRADO);
        }
    }

    private Instant issuedAt() {
        return LocalDateTime.now().toInstant(ZoneOffset.of(OFFSET_ID));
    }

    private Instant expiresAt() {
        return LocalDateTime.now().plusHours(EXPIRATION_HOURS).toInstant(ZoneOffset.of(OFFSET_ID));
    }
}
