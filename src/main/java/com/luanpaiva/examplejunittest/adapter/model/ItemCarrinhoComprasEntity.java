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
@Table(name = "tbl_item_carrinho_compras")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ItemCarrinhoComprasEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private ProdutoEntity produto;
    private Integer quantidade;
    @ManyToOne
    private CarrinhoComprasEntity carrinhoCompras;
}
