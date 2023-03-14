package br.com.fiap.cde.models;

public class Produto {

  private Long id;
  private String produto;
  private String descricao;
  private Integer quantidade;

  public Produto(
    Long id,
    String produto,
    String descricao,
    Integer quantidade
  ) {
    this.id = id;
    this.produto = produto;
    this.descricao = descricao;
    this.quantidade = quantidade;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getProduto() {
    return produto;
  }

  public void setProduto(String produto) {
    this.produto = produto;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  @Override
  public String toString() {
    return (
      "Produto [id=" +
      id +
      ", produto=" +
      produto +
      ", descricao=" +
      descricao +
      ", quantidade=" +
      quantidade +
      "]"
    );
  }
}
