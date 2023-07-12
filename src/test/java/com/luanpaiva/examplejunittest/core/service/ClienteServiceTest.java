package com.luanpaiva.examplejunittest.core.service;

import com.luanpaiva.examplejunittest.core.model.Cartao;
import com.luanpaiva.examplejunittest.core.model.Cliente;
import com.luanpaiva.examplejunittest.core.port.repository.ClienteRepositoryPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;
    @Mock
    private ClienteRepositoryPort clienteRepositoryPort;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        this.cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("John Doe");
        cliente.setCpf("123.456.789-10");
        cliente.setEmail("johndoe@email.com");
    }

    @Test
    void deveSalvarUmClienteComSucessoSemOfuscarONumeroDoCartao() {

        Mockito.when(clienteRepositoryPort.save(any(Cliente.class)))
                .thenReturn(cliente);

        Cliente clienteSalvo = clienteService.save(cliente);
        assertNotNull(clienteSalvo);
        assertEquals(cliente.getId(), clienteSalvo.getId());
        assertEquals(cliente.getNome(), clienteSalvo.getNome());
        assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
        assertEquals(cliente.getEmail(), clienteSalvo.getEmail());
    }

    @Test
    void deveSalvarUmClienteComSucessoEDeveOfuscarONumeroDoCartao() {

        Cartao cartao = new Cartao();
        cartao.setNumero("1234432156788765");

        cliente.setCartoes(List.of(cartao));

        Mockito.when(clienteRepositoryPort.save(any(Cliente.class)))
                .thenReturn(cliente);

        Cliente clienteSalvo = clienteService.save(cliente);
        assertNotNull(clienteSalvo);
        assertEquals(cliente.getId(), clienteSalvo.getId());
        assertEquals(cliente.getNome(), clienteSalvo.getNome());
        assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
        assertEquals(cliente.getEmail(), clienteSalvo.getEmail());
        assertEquals("1234********8765", clienteSalvo.getCartoes().get(0).getNumero());
    }
}
