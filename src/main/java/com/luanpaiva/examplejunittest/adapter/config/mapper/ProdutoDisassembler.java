package com.luanpaiva.examplejunittest.adapter.config.mapper;

import com.luanpaiva.examplejunittest.adapter.model.input.ProdutoInput;
import com.luanpaiva.examplejunittest.core.model.Produto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProdutoDisassembler implements MapperToDomainObject<ProdutoInput, Produto> {

    private final ModelMapper modelMapper;

    @Override
    public Produto toDomainObject(ProdutoInput produtoInput) {
        return modelMapper.map(produtoInput, Produto.class);
    }

    @Override
    public List<Produto> toDomainObjectList(List<ProdutoInput> produtoInputList) {
        return produtoInputList.stream().map(produtoInput -> modelMapper.map(produtoInput, Produto.class)).toList();
    }
}
