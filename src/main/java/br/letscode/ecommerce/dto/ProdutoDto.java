package br.letscode.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDto {
  private String nome;
  private String preco;
  private String descricao;
  public ProdutoDto() {
  }

}
