package br.letscode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.letscode.ecommerce.entity.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {
  
}
