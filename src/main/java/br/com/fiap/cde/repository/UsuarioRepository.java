package br.com.fiap.cde.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.cde.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{}