package com.luanpaiva.examplejunittest.adapter.input.api.v1;

import com.luanpaiva.examplejunittest.adapter.model.dto.TokenDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Login", description = "Responsável por autenticar o usuário na API.")
public interface ILoginController {

    @Operation(summary = "Login do usuário", description = "Responsável por fazer login e autenticar o usuário.")
    ResponseEntity<TokenDto> login(String email, String senha);
}
