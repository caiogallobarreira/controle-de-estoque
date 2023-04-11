package br.com.fiap.cde.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
  private String nome;

  @NotNull @Size(min = 3, max = 255, message = "O email deve ter entre 3 e 255 caracteres")
  private String email;
}