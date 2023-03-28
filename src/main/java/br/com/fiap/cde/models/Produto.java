package br.com.fiap.cde.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long estoqueId;
  private String nome;
  private String descricao;
  private String imagemUrl;
  private Integer quantidade;
  private Integer quantidadeMinima;

  protected Produto() {
  }

  public Produto(Long id, Long estoqueId, String nome, String descricao, String imagemUrl, Integer quantidade,
      Integer quantidadeMinima) {
    this.id = id;
    this.estoqueId = estoqueId;
    this.nome = nome;
    this.descricao = descricao;
    this.imagemUrl = imagemUrl;
    this.quantidade = quantidade;
    this.quantidadeMinima = quantidadeMinima;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getEstoqueId() {
    return estoqueId;
  }

  public void setEstoqueId(Long estoqueId) {
    this.estoqueId = estoqueId;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getImagemUrl() {
    return imagemUrl;
  }

  public void setImagemUrl(String imagemUrl) {
    this.imagemUrl = imagemUrl;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public Integer getQuantidadeMinima() {
    return quantidadeMinima;
  }

  public void setQuantidadeMinima(Integer quantidadeMinima) {
    this.quantidadeMinima = quantidadeMinima;
  }

  @Override
  public String toString() {
    return "Produto [id=" + id + ", estoqueId=" + estoqueId + ", nome=" + nome + ", descricao=" + descricao
        + ", imagemUrl=" + imagemUrl + ", quantidade=" + quantidade + ", quantidadeMinima=" + quantidadeMinima + "]";
  }
}
