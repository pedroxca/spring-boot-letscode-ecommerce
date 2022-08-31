package br.letscode.ecommerce.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.letscode.ecommerce.dao.ProdutoDao;
import br.letscode.ecommerce.entity.Produto;
import br.letscode.ecommerce.exceptions.EcommerceException;
import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

  @Autowired
  ProdutoDao produtoDao;

  @Override
  public Message createProduto(Produto produto) {
    produtoDao.save(produto);
    return new Message("Novo produto salvo com sucesso");
  }

  @Override
  public Produto findProdutoById(Long id) {
    Optional<Produto> produtoOptional = produtoDao.findById(id);
    if (produtoOptional.isEmpty()) {
      throw new EcommerceException("Produto não foi encontrado", 404);
    }
    return produtoOptional.get();
  }

  @Override
  public Message deleteProduto(Long id) {
    Optional<Produto> produtoOptional = produtoDao.findById(id);
    if (produtoOptional.isEmpty()) {
      throw new EcommerceException("Produto não foi encontrado", 404);
    }
    Message message = new Message("Produto: " + produtoOptional.get() + " removido com sucesso");
    produtoDao.deleteById(id);
    return message;
  }

  @Override
  public Message updateProduto(Produto produto, Long id) {
    Optional<Produto> produtoOptional = produtoDao.findById(id);
    if (produtoOptional.isEmpty()) {
      throw new EcommerceException("Produto não foi encontrado", 404);
    }
    Message message = new Message("Produto: " + produtoOptional.get() + " removido com sucesso");
    produtoDao.save(produto);
    return message;
  }

}
