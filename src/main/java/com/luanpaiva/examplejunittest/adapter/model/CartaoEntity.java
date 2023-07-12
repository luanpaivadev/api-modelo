package com.luanpaiva.examplejunittest.adapter.model;

import com.luanpaiva.examplejunittest.core.model.enums.Bandeira;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_cartao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CartaoEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Bandeira bandeira;
    private String numero;
    private String validade;
    private String cvv;
    @ManyToOne
    private ClienteEntity cliente;
}
