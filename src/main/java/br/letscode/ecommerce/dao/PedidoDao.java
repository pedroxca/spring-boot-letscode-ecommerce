package br.letscode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.letscode.ecommerce.entity.Pedido;

public interface PedidoDao extends JpaRepository<Pedido, Long> {
  
}
