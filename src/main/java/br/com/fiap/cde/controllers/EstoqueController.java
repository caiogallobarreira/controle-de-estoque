package br.com.fiap.cde.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.cde.models.Estoque;

@RestController
public class EstoqueController {
 
    Logger logger = LoggerFactory.getLogger(EstoqueController.class);

    // ! Apenas para testes !
    List<Estoque> estoques = new ArrayList<Estoque>();

    // Get All
    @GetMapping("/api/v1/estoque")
    public List<Estoque> index(){
        logger.info("Listando estoques: " + estoques);
        return estoques;
    }

    // Get by Id
    @GetMapping("/api/v1/estoque/{id}")
    public ResponseEntity<Estoque> show(@PathVariable Long id){
        logger.info("Listando estoque: " + id);
        Optional<Estoque> estoqueOptional = estoques.stream().filter(e -> e.getId().equals(id)).findFirst();
        if (estoqueOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        return ResponseEntity.ok(estoqueOptional.get());
    }

    // Post
    @PostMapping("/api/v1/estoque")
    public ResponseEntity<Estoque> create(@RequestBody Estoque estoque){
        logger.info("Estoque criado com sucesso! " + estoque);
        estoques.add(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoque);
    }

    // Delete
    @DeleteMapping("/api/v1/estoque/{id}")
    public ResponseEntity<Estoque> delete(@PathVariable Long id){
        logger.info("Estoque deletado com sucesso! " + id);
        Optional<Estoque> estoqueOptional = estoques.stream().filter(e -> e.getId().equals(id)).findFirst();
        if (estoqueOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        estoques.remove(estoqueOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("/api/v1/estoque/{id}")
    public ResponseEntity<Estoque> update(@PathVariable Long id, @RequestBody Estoque estoque){
        logger.info("Estoque atualizado com sucesso! " + estoque);
        Optional<Estoque> estoqueOptional = estoques.stream().filter(e -> e.getId().equals(id)).findFirst();
        if (estoqueOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        estoque.setId(id);
        estoques.remove(estoqueOptional.get());
        estoques.add(estoque);
        return ResponseEntity.ok(estoque);
    }
}