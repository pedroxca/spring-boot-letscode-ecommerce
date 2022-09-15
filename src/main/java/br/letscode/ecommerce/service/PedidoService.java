package br.letscode.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import br.letscode.ecommerce.dto.PedidoDto;
import br.letscode.ecommerce.dto.PedidoDtoResource;
import br.letscode.ecommerce.models.Message;

public interface PedidoService {
  public Message fazerPedido(PedidoDto pedidoDto);
  public Message cancelarPedido(Long id);
  public Message pedidoChegou(Long id);
  public ArrayList<PedidoDtoResource> getAllPedidos();
  public PedidoDtoResource getPedidoById(Long id);
}
