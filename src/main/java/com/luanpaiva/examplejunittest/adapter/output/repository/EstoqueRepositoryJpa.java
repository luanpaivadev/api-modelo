package com.luanpaiva.examplejunittest.adapter.output.repository;

import com.luanpaiva.examplejunittest.adapter.model.EstoqueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepositoryJpa extends JpaRepository<EstoqueEntity, Long> {
}
