package br.com.fiap.cde.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cde.models.Produto;

@RestController
public class ProdutoController {

    Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    // ! Apenas para testes !
    List<Produto> produtos = new ArrayList<Produto>();

    @GetMapping("/api/v1/produto")
    public List<Produto> index(){
        logger.info("Listando produtos: " + produtos);
        return produtos;
    }
    
    @GetMapping("/api/v1/produto/{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id){
        logger.info("Listando produto: " + id);
        Optional<Produto> produto = produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (produto.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(produto.get());
    }

    @PostMapping("/api/v1/produto")
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        logger.info("Produto criado com sucesso! " + produto);
        produtos.add(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

}

