package br.com.fiap.cde.models;

import org.springframework.hateoas.EntityModel;

import br.com.fiap.cde.controllers.UsuarioController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.data.domain.Pageable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Usuario {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
  private String nome;

  @NotNull @Size(min = 3, max = 255, message = "O email deve ter entre 3 e 255 caracteres")
  private String email;

  public EntityModel<Usuario> toEntityModel(){
    return EntityModel.of(
      this,
      linkTo(methodOn(UsuarioController.class).show(this.getId())).withSelfRel(),
      linkTo(methodOn(UsuarioController.class).delete(this.getId())).withRel("delete"),
      linkTo(methodOn(UsuarioController.class).index(null, Pageable.unpaged())).withRel("all")      
    );
  };
}