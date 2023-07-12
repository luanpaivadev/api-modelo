package com.luanpaiva.examplejunittest.core.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class CarrinhoCompras {

    private Long id;
    private List<ItemCarrinhoCompras> itens;
    private BigDecimal valorTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemCarrinhoCompras> getItens() {
        return itens;
    }

    public void setItens(List<ItemCarrinhoCompras> itens) {
        this.itens = itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoCompras that = (CarrinhoCompras) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
