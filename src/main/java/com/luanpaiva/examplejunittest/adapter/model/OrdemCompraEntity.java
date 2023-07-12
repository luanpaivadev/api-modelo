package com.luanpaiva.examplejunittest.adapter.model;

import com.luanpaiva.examplejunittest.core.model.enums.FormaPagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_ordem_compra")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrdemCompraEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ClienteEntity cliente;
    @OneToOne
    private CarrinhoComprasEntity carrinhoCompras;
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;
    @ManyToOne
    private EnderecoEntity endereco;
}
