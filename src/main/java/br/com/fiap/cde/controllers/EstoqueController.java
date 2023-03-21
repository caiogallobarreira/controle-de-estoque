package br.com.fiap.cde.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cde.models.Estoque;

@RestController
public class EstoqueController {
 
    @GetMapping("/api/v1/estoque")
    public Estoque index(){
        return new Estoque(1l, "Teste", "Teste");
    }

    @GetMapping("/api/v1/estoque/{id}")
    public Estoque show(@PathVariable Long id){
        return new Estoque(id, "Teste", "Teste");
    }
}