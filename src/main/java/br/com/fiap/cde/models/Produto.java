package br.com.fiap.cde.models;

public class Produto {

  private Long id;
  private String nome;
  private String descricao;
  private String imagemUrl;
  private Integer quantidade;
  private Integer quantidadeMin;

  public Produto(Long id, String nome, String descricao, String imagemUrl, Integer quantidade, Integer quantidadeMin) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.imagemUrl = imagemUrl;
    this.quantidade = quantidade;
    this.quantidadeMin = quantidadeMin;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Integer getQuantidadeMin() {
    return quantidadeMin;
  }

  public void setQuantidadeMin(Integer quantidadeMin) {
    this.quantidadeMin = quantidadeMin;
  }

  @Override
  public String toString() {
    return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", imagemUrl=" + imagemUrl
        + ", quantidade=" + quantidade + ", quantidadeMin=" + quantidadeMin + "]";
  }
}
