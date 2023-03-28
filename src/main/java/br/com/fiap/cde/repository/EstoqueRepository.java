package br.com.fiap.cde.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.cde.models.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
    
}