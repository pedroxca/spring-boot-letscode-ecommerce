package br.letscode.ecommerce.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.letscode.ecommerce.dao.ClienteDao;
import br.letscode.ecommerce.dto.ClienteDtoComSenha;
import br.letscode.ecommerce.dto.ClienteDtoSemSenha;
import br.letscode.ecommerce.entity.Cliente;
import br.letscode.ecommerce.exceptions.EcommerceException;
import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.models.PerfilEnum;
import br.letscode.ecommerce.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  ClienteDao clienteDao;

  @Autowired
  private final PasswordEncoder passwordEncoder;

  public ClienteServiceImpl(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public List<Cliente> getAllClients() {
    return clienteDao.findAll();
  }

  @Override
  public Message novoCliente(ClienteDtoComSenha clienteDto) {
    clienteDto.setSenha(passwordEncoder.encode(clienteDto.getSenha()));
    Cliente cliente = new Cliente(clienteDto.getNome(), clienteDto.getSobrenome(), clienteDto.getEmail(),
        clienteDto.getSexo(), clienteDto.getCpf(), clienteDto.getSenha(), PerfilEnum.CLIENTE);
    clienteDao.save(cliente);
    cliente.setSenha("");
    return new Message("Cliente: " + cliente + " salvo");
  }

  @Override
  public Message atualizarCliente(ClienteDtoSemSenha clienteDto, Long id) {
    Optional<Cliente> clienteFoundById = clienteDao.findById(id);
    if (clienteFoundById.isEmpty()) {
      throw new EcommerceException("Cliente não existe", 404);
    }
    Cliente cliente = new Cliente(clienteFoundById.get().getId(), clienteDto.getNome(), clienteDto.getSobrenome(),
        clienteDto.getEmail(),
        clienteDto.getSexo(), clienteDto.getCpf(), clienteFoundById.get().getSenha(), clienteDto.getPerfilEnum());
    clienteDao.save(cliente);
    return new Message("Cliente: " + cliente + " salvo com sucesso");
  }

  @Override
  public Message removerCliente(Long id) {
    Optional<Cliente> clienteOptional = clienteDao.findById(id);
    if (clienteOptional.isEmpty()) {
      throw new EcommerceException("Cliente não existe", 404);
    }
    clienteDao.deleteById(id);
    return new Message("Cliente: " + clienteOptional.get() + " deletado com sucesso");
  }

  @Override
  public Cliente findByCpf(String cpf) {
    if (clienteDao.findByCpf(cpf).isEmpty()) {
      throw new EcommerceException("Cliente não existe", 404);
    }
    return clienteDao.findByCpf(cpf).get();
  }

  @Override
  public Cliente findById(Long id) {
    Optional<Cliente> clienteOptional = clienteDao.findById(id);
    if (clienteOptional.isEmpty()) {
      throw new EcommerceException("Cliente não existe", 404);
    }
    return clienteOptional.get();
  }
}
