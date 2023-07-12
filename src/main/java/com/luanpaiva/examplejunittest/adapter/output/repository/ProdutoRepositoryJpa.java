package com.luanpaiva.examplejunittest.adapter.output.repository;

import com.luanpaiva.examplejunittest.adapter.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositoryJpa extends JpaRepository<ProdutoEntity, Long> {
}
