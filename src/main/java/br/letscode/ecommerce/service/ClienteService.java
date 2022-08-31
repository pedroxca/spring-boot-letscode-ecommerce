package br.letscode.ecommerce.service;

import java.util.List;

import br.letscode.ecommerce.dto.ClienteDto;
import br.letscode.ecommerce.entity.Cliente;
import br.letscode.ecommerce.models.Message;

public interface ClienteService {
  public List<Cliente> getAllClients();

  public Message novoCliente(ClienteDto cliente);

  public Message atualizarCliente(ClienteDto clienteDto, Long id);

  public Message removerCliente(long id);
  public Cliente findByCpf(String cpf);
}
