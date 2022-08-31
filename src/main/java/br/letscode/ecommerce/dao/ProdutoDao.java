package br.letscode.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.letscode.ecommerce.entity.Produto;

public interface ProdutoDao extends JpaRepository<Produto, Long> {
  
}
