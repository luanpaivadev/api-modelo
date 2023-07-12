package com.luanpaiva.examplejunittest.adapter.input.api.v1.controller;

import com.luanpaiva.examplejunittest.adapter.config.mapper.ProdutoAssembler;
import com.luanpaiva.examplejunittest.adapter.config.mapper.ProdutoDisassembler;
import com.luanpaiva.examplejunittest.adapter.model.dto.ProdutoDto;
import com.luanpaiva.examplejunittest.adapter.model.input.ProdutoInput;
import com.luanpaiva.examplejunittest.core.model.Produto;
import com.luanpaiva.examplejunittest.core.port.service.ProdutoServicePort;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.luanpaiva.examplejunittest.core.constant.Roles.ROLE_ADMIN;
import static com.luanpaiva.examplejunittest.core.constant.Roles.ROLE_USER;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;
    private final ProdutoAssembler produtoAssembler;
    private final ProdutoDisassembler produtoDisassembler;

    @PostMapping
    @Secured(ROLE_ADMIN)
    public ResponseEntity<ProdutoDto> save(@RequestBody ProdutoInput produtoInput) {
        Produto produto = produtoDisassembler.toDomainObject(produtoInput);
        produto = produtoServicePort.save(produto);
        ProdutoDto produtoDto = produtoAssembler.toDtoObject(produto);
        return ResponseEntity.ok(produtoDto);
    }

    @GetMapping("/{id}")
    @Secured(ROLE_USER)
    public ResponseEntity<ProdutoDto> findById(@PathVariable Long id) {
        Produto produto = produtoServicePort.findById(id);
        ProdutoDto produtoDto = produtoAssembler.toDtoObject(produto);
        return ResponseEntity.ok(produtoDto);
    }
}
