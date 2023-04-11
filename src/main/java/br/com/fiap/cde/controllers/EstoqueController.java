package br.com.fiap.cde.controllers;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.cde.exceptions.RestNotFoundException;
import br.com.fiap.cde.models.Estoque;
import br.com.fiap.cde.repository.EstoqueRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/estoque")
public class EstoqueController {
 
    Logger logger = LoggerFactory.getLogger(EstoqueController.class);

    @Autowired
    EstoqueRepository repository;

    // Get All
    @GetMapping
    public List<Estoque> index(){
        logger.info("Listando estoques" );
        return repository.findAll();
    }

    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Estoque> show(@PathVariable Long id){
        var estoqueOptional = getEstoque(id);
        logger.info("Listando estoque: " + id);
        return ResponseEntity.ok(estoqueOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<Estoque> create(@RequestBody @Valid Estoque estoque, BindingResult result){
        logger.info("Estoque criado com sucesso! " + estoque);
        repository.save(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoque);
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Estoque> delete(@PathVariable Long id){
        var estoqueOptional = getEstoque(id);
        logger.info("Estoque deletado com sucesso! " + id);
        repository.delete(estoqueOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Estoque> update(@PathVariable Long id, @RequestBody @Valid Estoque estoque, BindingResult result){
        getEstoque(id);
        logger.info("Estoque atualizado com sucesso! " + estoque);
        estoque.setId(id);
        repository.save(estoque);
        return ResponseEntity.ok(estoque);
    }

    private Estoque getEstoque(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Estoque não encontrado!"));
    }
}