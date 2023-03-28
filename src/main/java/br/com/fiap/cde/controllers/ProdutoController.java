package br.com.fiap.cde.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cde.models.Produto;
import br.com.fiap.cde.repository.ProdutoRepository;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {

    Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    ProdutoRepository repository;

    // Get ALL
    @GetMapping
    public List<Produto> index(){
        logger.info("Listando produtos");
        return repository.findAll();
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id){
        logger.info("Listando produto: " + id);
        Optional<Produto> produtoOptional = repository.findById(id);
        if (produtoOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(produtoOptional.get());
    }

    // Post
    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto produto){
        logger.info("Produto criado com sucesso! " + produto);
        repository.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Produto> delete(@PathVariable Long id){
        logger.info("Produto deletado com sucesso! " + id);
        Optional<Produto> produtoOptional = repository.findById(id);
        if (produtoOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.delete(produtoOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto){
        logger.info("Produto atualizado com sucesso! " + produto);
        Optional<Produto> produtoOptional = repository.findById(id);
        if (produtoOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        produto.setId(id);
        repository.save(produto);
        return ResponseEntity.ok(produto);
    }

}

