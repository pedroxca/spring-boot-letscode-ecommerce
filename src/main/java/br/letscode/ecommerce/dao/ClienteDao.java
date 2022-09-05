package br.letscode.ecommerce.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.letscode.ecommerce.entity.Cliente;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long> {
  public Optional<Cliente> findByCpf(String cpf);
  public Cliente findByEmail(String email);
}
