package br.letscode.ecommerce.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.letscode.ecommerce.dao.ClienteDao;
import br.letscode.ecommerce.dto.ClienteDto;
import br.letscode.ecommerce.entity.Cliente;
import br.letscode.ecommerce.exceptions.EcommerceException;
import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  ClienteDao clienteDao;

  @Override
  public List<Cliente> getAllClients() {
    return clienteDao.findAll();
  }

  @Override
  public Message novoCliente(ClienteDto clienteDto) {
    Cliente cliente = new Cliente(clienteDto.getNome(), clienteDto.getSobrenome(), clienteDto.getEmail(),
        clienteDto.getSexo(), clienteDto.getCpf());
    clienteDao.save(cliente);
    return new Message("Cliente: " + cliente + " salvo");
  }

  @Override
  public Message atualizarCliente(ClienteDto clienteDto, Long id) {
    Optional<Cliente> clienteFoundById = clienteDao.findById(id);
    if (clienteFoundById.isEmpty()) {
      throw new EcommerceException("Cliente não existe", 404);
    }
    Cliente cliente = new Cliente(clienteFoundById.get().getId(), clienteDto.getNome(), clienteDto.getSobrenome(),
        clienteDto.getEmail(),
        clienteDto.getSexo(), clienteDto.getCpf());
    clienteDao.save(cliente);
    return new Message("Cliente: " + cliente + " salvo com sucesso");
  }

  @Override
  public Message removerCliente(long id) {
    clienteDao.deleteById(id);
    return new Message("Cliente: " + clienteDao.findById(id) + " deletado com sucesso");
  }

  @Override
  public Cliente findByCpf(String cpf) {
    if (clienteDao.findByCpf(cpf).isEmpty()) {
      throw new EcommerceException("Cliente não existe", 404);
    }
    return clienteDao.findByCpf(cpf).get();
  }
}
