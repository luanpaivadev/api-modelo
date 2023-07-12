package com.luanpaiva.examplejunittest.adapter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_carrinho_compras")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CarrinhoComprasEntity {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "carrinhoCompras")
    private List<ItemCarrinhoComprasEntity> itens;
    private BigDecimal valorTotal;
}
