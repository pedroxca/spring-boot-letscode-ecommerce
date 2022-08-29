package br.letscode.ecommerce.service;

import java.util.List;

import br.letscode.ecommerce.dto.ClienteDto;
import br.letscode.ecommerce.entity.Cliente;

public interface ClienteService {
  public List<Cliente> getAllClients();

  public boolean novoCliente(ClienteDto cliente);

  public boolean atualizarCliente(ClienteDto clienteDto, Long id);

  public boolean removerCliente(long id);
}
