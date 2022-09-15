package br.letscode.ecommerce.controller.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.letscode.ecommerce.dto.PedidoDto;
import br.letscode.ecommerce.dto.PedidoDtoResource;
import br.letscode.ecommerce.entity.Pedido;
import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/api/v1/pedido")
public class PedidoController {


  @Autowired
  PedidoService pedidoService;
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Message> createProduto(@RequestBody PedidoDto pedidoDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.fazerPedido(pedidoDto));
  };

  @RequestMapping(method = RequestMethod.GET, path = "/{id}")
  public ResponseEntity<PedidoDtoResource> getProdutoById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(pedidoService.getPedidoById(id));
  };

  @RequestMapping(method = RequestMethod.GET, path = "")
  public ResponseEntity<ArrayList<PedidoDtoResource>> getProdutos() {

    return ResponseEntity.status(HttpStatus.OK).body(pedidoService.getAllPedidos());
  };

  @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
  public ResponseEntity<Message> deleteProdutoById(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(pedidoService.cancelarPedido(id));
  };

  @PreAuthorize("hasAnyRole('ADMIN')")
  @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
  public ResponseEntity<Message> updateProduto(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(pedidoService.pedidoChegou(id));
  };
}
