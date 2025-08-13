package com.challenge.foro_hub.repository;

import com.challenge.foro_hub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
