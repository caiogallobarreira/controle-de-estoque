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

import br.com.fiap.cde.models.Usuario;

@RestController
public class UsuarioController {
    
    Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    // ! Apenas para testes !
    List<Usuario> usuarios = new ArrayList<Usuario>();

    // Get ALL
    @GetMapping("/api/v1/usuario")
    public List<Usuario> index(){
        logger.info("Listando usuarios: " + usuarios);
        return usuarios;
    }

    // Get by Id
    @GetMapping("/api/v1/usuario/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        logger.info("Listando usuario: " + id);
        Optional<Usuario> usuarioOptional = usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (usuarioOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuarioOptional.get());
    }

    // Post
    @PostMapping("/api/v1/usuario")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        logger.info("Usuario criado com sucesso! " + usuario);
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // Delete
    @DeleteMapping("/api/v1/usuario/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        logger.info("Usuario deletado com sucesso! " + id);
        Optional<Usuario> usuarioOptional = usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (usuarioOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuarios.remove(usuarioOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("/api/v1/usuario/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        logger.info("Usuario atualizado com sucesso! " + id);
        Optional<Usuario> usuarioOptional = usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (usuarioOptional.isEmpty()) 
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuario.setId(id);
        usuarios.remove(usuarioOptional.get());
        usuarios.add(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }
}
