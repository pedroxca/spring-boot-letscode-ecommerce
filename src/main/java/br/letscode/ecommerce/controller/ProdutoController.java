package br.letscode.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.letscode.ecommerce.entity.Produto;
import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/api/v1/produto")
public class ProdutoController {
  @Autowired
  ProdutoService produtoService;

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Message> createProduto(@RequestBody Produto produto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.createProduto(produto));
  };
  
  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
    
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.findProdutoById(id));
  };
  
  @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
  public ResponseEntity<Message> deleteProdutoById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.deleteProduto(id));
  };
  
  @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
  public ResponseEntity<Message> updateProduto(@RequestBody Produto produto, @PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.updateProduto(produto, id));
  };
}
