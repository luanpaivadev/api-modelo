package com.luanpaiva.examplejunittest.adapter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_endereco")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EnderecoEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String localidade;
    private String bairro;
    private String uf;
    @ManyToOne
    private ClienteEntity cliente;
}
