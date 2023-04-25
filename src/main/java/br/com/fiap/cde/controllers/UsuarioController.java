package br.com.fiap.cde.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
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
import br.com.fiap.cde.models.Usuario;
import br.com.fiap.cde.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController @Slf4j
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    PagedResourcesAssembler<Object> assembler; 

    // Get ALL
    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String search, @PageableDefault(size = 5) Pageable pageable){
        var usuarios = (search == null) ? repository.findAll(pageable) : repository.findByNomeContaining(search, pageable);
        return assembler.toModel(usuarios.map(Usuario::toEntityModel));
    }

    // Get by Id
    @GetMapping("{id}")
    public ResponseEntity<EntityModel<Usuario>> show(@PathVariable Long id){
        log.info("Listando usuario: " + id);
        return ResponseEntity.ok(getUsuario(id).toEntityModel());
    }

    // Post
    @PostMapping
    public ResponseEntity<EntityModel<Usuario>> create(@RequestBody @Valid Usuario usuario, BindingResult result){
        log.info("Usuario criado com sucesso! " + usuario);
        repository.save(usuario);
        return ResponseEntity.created(usuario.toEntityModel().getRequiredLink("self").toUri()).body(usuario.toEntityModel());
    }

    // Delete
    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> delete(@PathVariable Long id){
        log.info("Usuario deletado com sucesso! " + id);
        var usuarioOptional = getUsuario(id);
        repository.delete(usuarioOptional);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Put
    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario, BindingResult result){
        log.info("Usuario atualizado com sucesso! " + id);
        getUsuario(id);
        usuario.setId(id);
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    private Usuario getUsuario(Long id) {
        return repository.findById(id).orElseThrow(() -> new RestNotFoundException("Usuário não encontrado!"));
    }
}