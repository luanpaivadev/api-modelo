package com.luanpaiva.examplejunittest.adapter.input.api.v1.controller;

import com.luanpaiva.examplejunittest.adapter.auth.TokenService;
import com.luanpaiva.examplejunittest.adapter.input.api.v1.ILoginController;
import com.luanpaiva.examplejunittest.adapter.model.dto.TokenDto;
import com.luanpaiva.examplejunittest.core.model.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/login")
public class LoginController implements ILoginController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<TokenDto> login(@RequestParam final String email, @RequestParam final String senha) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, senha);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        String tokenJWT = tokenService.gerarToken((Usuario) authenticate.getPrincipal());
        return ResponseEntity.ok(new TokenDto(tokenJWT));
    }
}
