package br.letscode.ecommerce.service;

import br.letscode.ecommerce.entity.Produto;
import br.letscode.ecommerce.models.Message;

public interface ProdutoService {
  public Message createProduto(Produto produto);
  public Produto findProdutoById(Long id);
  public Message deleteProduto(Long id);
  public Message updateProduto(Produto produto, Long id);
}
