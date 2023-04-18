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
import br.com.fiap.cde.models.Produto;
import br.com.fiap.cde.repository.EstoqueRepository;
import br.com.fiap.cde.repository.ProdutoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/produto")
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;
    
    @Autowired
    EstoqueRepository estoqueRepository;

    // Get ALL
    @GetMapping
    public Page<Produto> index(@RequestParam(required = false) String search, Pageable pageable){
        log.info("Listando produtos");
        if (search != null) return produtoRepository.findByNomeContaining(search, pageable);
        return produtoRepository.findAll(pageable);
    }
    
    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Produto> show(@PathVariable Long id){
        var produtoOptional = getProduto(id);
        log.info("Listando produto: " + id);
        return ResponseEntity.ok(produtoOptional);
    }

    // Post
    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody @Valid Produto produto, BindingResult result){
        log.info("Produto criado com sucesso! " + produto);
        produtoRepository.save(produto);
        produto.setEstoque(estoqueRepository.findById(produto.getEstoque().getId()).get());
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Produto> delete(@PathVariable Long id){
        var produtoOptional = getProduto(id);
        log.info("Produto deletado com sucesso! " + id);
        produtoRepository.delete(produtoOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody @Valid Produto produto, BindingResult result){
        getProduto(id);
        log.info("Produto atualizado com sucesso! " + produto);
        produto.setId(id);
        produtoRepository.save(produto);
        return ResponseEntity.ok(produto);
    }

    private Produto getProduto(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new RestNotFoundException("Produto não encontrado!"));
    }
}