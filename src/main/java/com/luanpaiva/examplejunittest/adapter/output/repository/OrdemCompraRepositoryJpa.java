package com.luanpaiva.examplejunittest.adapter.output.repository;

import com.luanpaiva.examplejunittest.adapter.model.OrdemCompraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemCompraRepositoryJpa extends JpaRepository<OrdemCompraEntity, Long> {
}
