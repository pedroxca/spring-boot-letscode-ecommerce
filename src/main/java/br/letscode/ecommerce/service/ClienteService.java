package br.letscode.ecommerce.service;

import java.util.List;

import br.letscode.ecommerce.dto.ClienteDtoComSenha;
import br.letscode.ecommerce.dto.ClienteDtoSemSenha;
import br.letscode.ecommerce.entity.Cliente;
import br.letscode.ecommerce.models.Message;

public interface ClienteService {
  
  public List<Cliente> getAllClients();

  
  public Message novoCliente(ClienteDtoComSenha clienteDto) ;
  
  public Message atualizarCliente(ClienteDtoSemSenha clienteDto, Long id);

  
  public Message removerCliente(Long id);

  
  public Cliente findByCpf(String cpf);
  
  public Cliente findById(Long id);
}
