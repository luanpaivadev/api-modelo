package com.luanpaiva.examplejunittest.adapter.output.repository;

import com.luanpaiva.examplejunittest.adapter.model.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepositoryJpa extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findByEmail(String email);
}
