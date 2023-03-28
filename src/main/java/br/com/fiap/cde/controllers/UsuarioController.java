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

import br.com.fiap.cde.models.Usuario;
import br.com.fiap.cde.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {
    
    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioRepository repository;

    // Get ALL
    @GetMapping
    public List<Usuario> index(){
        logger.info("Listando usuarios");
        return repository.findAll();
    }

    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        logger.info("Listando usuario: " + id);
        Optional<Usuario> usuarioOptional = repository.findById(id);
        if (usuarioOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuarioOptional.get());
    }

    // Post
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        logger.info("Usuario criado com sucesso! " + usuario);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        logger.info("Usuario deletado com sucesso! " + id);
        Optional<Usuario> usuarioOptional = repository.findById(id);
        if (usuarioOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        logger.info("Usuario atualizado com sucesso! " + id);
        Optional<Usuario> usuarioOptional = repository.findById(id);
        if (usuarioOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuario.setId(id);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
}
