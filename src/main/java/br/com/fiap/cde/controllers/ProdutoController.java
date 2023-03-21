package br.com.fiap.cde.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cde.models.Produto;

@RestController
public class ProdutoController {
    
    @GetMapping("/api/produto")
    public Produto index(){
        return new Produto(1l, "Faca", "Facas de cozinha com Lâminas em Aço Inox e Cabos de Polipropileno Preto", "https://www.example.com", 100, 5);
    }

}
