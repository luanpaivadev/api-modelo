package com.luanpaiva.examplejunittest.adapter.config;

import com.luanpaiva.examplejunittest.core.port.repository.ClienteRepositoryPort;
import com.luanpaiva.examplejunittest.core.port.service.ClienteServicePort;
import com.luanpaiva.examplejunittest.core.port.repository.EstoqueRepositoryPort;
import com.luanpaiva.examplejunittest.core.port.service.EstoqueServicePort;
import com.luanpaiva.examplejunittest.core.port.repository.OrdemCompraRepositoryPort;
import com.luanpaiva.examplejunittest.core.port.service.OrdemCompraServicePort;
import com.luanpaiva.examplejunittest.core.port.repository.ProdutoRepositoryPort;
import com.luanpaiva.examplejunittest.core.port.service.ProdutoServicePort;
import com.luanpaiva.examplejunittest.core.service.ClienteService;
import com.luanpaiva.examplejunittest.core.service.EstoqueService;
import com.luanpaiva.examplejunittest.core.service.OrdemCompraService;
import com.luanpaiva.examplejunittest.core.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBeans {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ClienteServicePort clienteServicePort(ClienteRepositoryPort clienteRepositoryPort) {
        return new ClienteService(clienteRepositoryPort);
    }

    @Bean
    public ProdutoServicePort produtoServicePort(ProdutoRepositoryPort produtoRepositoryPort) {
        return new ProdutoService(produtoRepositoryPort);
    }

    @Bean
    public EstoqueServicePort estoqueServicePort(EstoqueRepositoryPort estoqueRepositoryPort) {
        return new EstoqueService(estoqueRepositoryPort);
    }

    @Bean
    public OrdemCompraServicePort ordemCompraServicePort(OrdemCompraRepositoryPort ordemCompraRepositoryPort) {
        return new OrdemCompraService(ordemCompraRepositoryPort);
    }

}
