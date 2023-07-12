package com.luanpaiva.examplejunittest.adapter.config.mapper;

import com.luanpaiva.examplejunittest.adapter.model.dto.ProdutoDto;
import com.luanpaiva.examplejunittest.core.model.Produto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProdutoAssembler implements MapperToDtoObject<Produto, ProdutoDto> {

    private final ModelMapper modelMapper;

    @Override
    public ProdutoDto toDtoObject(Produto produto) {
        return modelMapper.map(produto, ProdutoDto.class);
    }

    @Override
    public List<ProdutoDto> toDtoObjectList(List<Produto> produtos) {
        return produtos.stream().map(produto -> modelMapper.map(produto, ProdutoDto.class)).toList();
    }
}
