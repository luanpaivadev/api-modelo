package com.luanpaiva.examplejunittest.adapter.model;

import com.luanpaiva.examplejunittest.core.model.enums.Roles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@Table(name = "tbl_usuario")
@EqualsAndHashCode(of = "id")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private List<Roles> roles;
}
