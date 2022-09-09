package br.letscode.ecommerce.controller.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.letscode.ecommerce.dto.ProdutoDto;
import br.letscode.ecommerce.entity.Produto;
import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.ProdutoService;

@RestController
@RequestMapping(path = "/api/v1/produto", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProdutoController {
  @Autowired
  ProdutoService produtoService;

  @PreAuthorize("hasAnyRole('ADMIN')")
  @Description(value = "Criar um produto novo")
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Message> createProduto(@RequestBody ProdutoDto produto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.createProduto(produto));
  };

  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  public ResponseEntity<Produto> getProdutoById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.findProdutoById(id));
  };

  @RequestMapping(method = RequestMethod.GET, path = "")
  public ResponseEntity<List<Produto>> getProdutos() {

    return ResponseEntity.status(HttpStatus.OK).body(produtoService.findAllProdutos());
  };

  @PreAuthorize("hasAnyRole('ADMIN')")
  @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
  public ResponseEntity<Message> deleteProdutoById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.deleteProduto(id));
  };

  @PreAuthorize("hasAnyRole('ADMIN')")
  @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
  public ResponseEntity<Message> updateProduto(@RequestBody ProdutoDto produto, @PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(produtoService.updateProduto(produto, id));
  };
}
