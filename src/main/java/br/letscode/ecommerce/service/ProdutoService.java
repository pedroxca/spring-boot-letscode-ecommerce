package br.letscode.ecommerce.service;

import java.util.List;

import br.letscode.ecommerce.dto.ProdutoDto;
import br.letscode.ecommerce.entity.Produto;
import br.letscode.ecommerce.models.Message;

public interface ProdutoService {
  public Message createProduto(ProdutoDto produto);
  public Produto findProdutoById(Long id);
  public Message deleteProduto(Long id);
  public Message updateProduto(ProdutoDto produto, Long id);
  public List<Produto> findAllProdutos();
}
