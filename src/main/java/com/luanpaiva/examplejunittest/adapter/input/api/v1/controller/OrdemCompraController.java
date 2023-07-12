package com.luanpaiva.examplejunittest.adapter.input.api.v1.controller;

import com.luanpaiva.examplejunittest.adapter.model.dto.OrdemCompraDto;
import com.luanpaiva.examplejunittest.adapter.model.input.OrdemCompraInput;
import com.luanpaiva.examplejunittest.core.model.OrdemCompra;
import com.luanpaiva.examplejunittest.core.port.service.OrdemCompraServicePort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/ordens-compra")
public class OrdemCompraController {

    private final OrdemCompraServicePort ordemCompraServicePort;
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<OrdemCompraDto> save(@RequestBody OrdemCompraInput ordemCompraInput) {
        OrdemCompra ordemCompra = modelMapper.map(ordemCompraInput, OrdemCompra.class);
        ordemCompra = ordemCompraServicePort.save(ordemCompra);
        OrdemCompraDto ordemCompraDto = modelMapper.map(ordemCompra, OrdemCompraDto.class);
        return ResponseEntity.ok(ordemCompraDto);
    }
}
