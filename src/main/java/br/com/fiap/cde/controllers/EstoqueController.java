package br.com.fiap.cde.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.fiap.cde.exceptions.RestNotFoundException;
import br.com.fiap.cde.models.Estoque;
import br.com.fiap.cde.repository.EstoqueRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/estoque")
public class EstoqueController {

    @Autowired
    EstoqueRepository repository;

    // Get All
    @GetMapping
    public Page<Estoque> index(@RequestParam(required = false) String search, Pageable pageable){
        log.info("Listando estoques");
        if (search != null) return repository.findByNomeContaining(search, pageable);
        return repository.findAll(pageable);
    }

    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Estoque> show(@PathVariable Long id){
        var estoqueOptional = getEstoque(id);
        log.info("Listando estoque: " + id);
        return ResponseEntity.ok(estoqueOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<Estoque> create(@RequestBody @Valid Estoque estoque, BindingResult result){
        log.info("Estoque criado com sucesso! " + estoque);
        repository.save(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).body(estoque);
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Estoque> delete(@PathVariable Long id){
        var estoqueOptional = getEstoque(id);
        log.info("Estoque deletado com sucesso! " + id);
        repository.delete(estoqueOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Estoque> update(@PathVariable Long id, @RequestBody @Valid Estoque estoque, BindingResult result){
        getEstoque(id);
        log.info("Estoque atualizado com sucesso! " + estoque);
        estoque.setId(id);
        repository.save(estoque);
        return ResponseEntity.ok(estoque);
    }

    private Estoque getEstoque(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Estoque não encontrado!"));
    }
}