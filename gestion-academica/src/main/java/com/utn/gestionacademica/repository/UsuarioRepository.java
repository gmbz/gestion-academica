package com.utn.gestionacademica.repository;

import com.utn.gestionacademica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
