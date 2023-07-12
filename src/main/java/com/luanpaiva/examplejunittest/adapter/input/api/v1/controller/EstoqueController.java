package com.luanpaiva.examplejunittest.adapter.input.api.v1.controller;

import com.luanpaiva.examplejunittest.adapter.model.dto.EstoqueDto;
import com.luanpaiva.examplejunittest.adapter.model.input.EstoqueInput;
import com.luanpaiva.examplejunittest.core.model.Estoque;
import com.luanpaiva.examplejunittest.core.port.service.EstoqueServicePort;
import com.luanpaiva.examplejunittest.core.port.service.ProdutoServicePort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/estoques")
public class EstoqueController {

    private final EstoqueServicePort estoqueServicePort;
    private final ProdutoServicePort produtoServicePort;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<EstoqueDto> save(@RequestBody EstoqueInput estoqueInput) {
        produtoServicePort.findById(estoqueInput.getProdutoId());
        Estoque estoque = modelMapper.map(estoqueInput, Estoque.class);
        estoque = estoqueServicePort.save(estoque);
        EstoqueDto estoqueDto = modelMapper.map(estoque, EstoqueDto.class);
        return ResponseEntity.ok(estoqueDto);
    }
}
