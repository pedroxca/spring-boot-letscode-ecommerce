package br.letscode.ecommerce.service;

import java.util.List;

import br.letscode.ecommerce.dto.PedidoDto;
import br.letscode.ecommerce.entity.Pedido;
import br.letscode.ecommerce.models.Message;

public interface PedidoService {
  public Message fazerPedido(PedidoDto pedidoDto);
  public Message cancelarPedido(Long id);
  public Message pedidoChegou(Long id);
  public List<Pedido> getAllPedidos();
  public Pedido getPedidoById(Long id);
}
