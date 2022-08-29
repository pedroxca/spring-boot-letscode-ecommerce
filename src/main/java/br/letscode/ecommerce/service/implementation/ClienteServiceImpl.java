package br.letscode.ecommerce.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.letscode.ecommerce.dao.ClienteDao;
import br.letscode.ecommerce.dto.ClienteDto;
import br.letscode.ecommerce.entity.Cliente;
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
  public boolean novoCliente(ClienteDto clienteDto) {
    try {
      Cliente cliente = new Cliente(clienteDto.getNome(), clienteDto.getSobrenome(), clienteDto.getEmail(),
          clienteDto.getSexo(), clienteDto.getCpf());
      clienteDao.save(cliente);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public boolean atualizarCliente(ClienteDto clienteDto, Long id) {
    try {
      Cliente cliente = new Cliente(id, clienteDto.getNome(), clienteDto.getSobrenome(), clienteDto.getEmail(),
          clienteDto.getSexo(), clienteDto.getCpf());
      clienteDao.save(cliente);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public boolean removerCliente(long id) {
    try {
      clienteDao.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

}
