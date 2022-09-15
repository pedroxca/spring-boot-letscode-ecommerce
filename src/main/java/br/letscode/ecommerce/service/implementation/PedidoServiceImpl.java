package br.letscode.ecommerce.service.implementation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.letscode.ecommerce.dao.ClienteDao;
import br.letscode.ecommerce.dao.PedidoDao;
import br.letscode.ecommerce.dao.ProdutoDao;
import br.letscode.ecommerce.dto.ClienteDtoSemSenha;
import br.letscode.ecommerce.dto.PedidoDto;
import br.letscode.ecommerce.dto.PedidoDtoResource;
import br.letscode.ecommerce.entity.Cliente;
import br.letscode.ecommerce.entity.Pedido;
import br.letscode.ecommerce.entity.Produto;
import br.letscode.ecommerce.exceptions.EcommerceException;
import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.PedidoService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PedidoServiceImpl implements PedidoService {

  @Autowired
  private PedidoDao pedidoDao;
  @Autowired
  private ProdutoDao produtoDao;
  @Autowired
  private ClienteDao clienteDao;

  @Override
  public Message fazerPedido(PedidoDto pedidoDto) {
    List<Optional<Produto>> listOfProdutosOptional = pedidoDto.getProdutoIds().stream().map(p -> produtoDao.findById(p))
        .collect(Collectors.toList());
    Optional<Cliente> clienteOptional = clienteDao.findById(pedidoDto.getClientId());
    log.error(clienteOptional.toString());
    listOfProdutosOptional.stream().forEach(produto -> {
      if (!(produto.isPresent()) || !(clienteOptional.isPresent())) {
        throw new EcommerceException("Cliente e/ou produto não existem", 400);
      }
    });
    List<Produto> produtos = listOfProdutosOptional.stream().map(p -> p.get()).collect(Collectors.toList());
    Cliente cliente = clienteOptional.get();
    Pedido pedido = new Pedido(false, false, cliente, produtos, LocalDateTime.now(),
        LocalDateTime.of(5000, 1, 1, 0, 0, 0));
    pedidoDao.save(pedido);
    return new Message("Pedido feito com sucesso!");
  }

  @Override
  public Message cancelarPedido(Long id) {
    Optional<Pedido> pedidoOptional = pedidoDao.findById(id);
    if (pedidoOptional.isEmpty()) {
      throw new EcommerceException("Pedido inexistente", 404);
    }
    pedidoOptional.get().setCancelado(Boolean.TRUE);
    pedidoOptional.get().setTerminado(Boolean.TRUE);
    pedidoOptional.get().setDataTerminado(LocalDateTime.now());
    return new Message("Pedido cancelado com sucesso 😭");
  }

  @Override
  public Message pedidoChegou(Long id) {
    Optional<Pedido> pedidoOptional = pedidoDao.findById(id);
    if (pedidoOptional.isEmpty()) {
      throw new EcommerceException("Pedido inexistente", 404);
    }
    pedidoOptional.get().setTerminado(Boolean.TRUE);
    pedidoOptional.get().setDataTerminado(LocalDateTime.now());
    return new Message("Pedido terminado");
  }

  @Override
  public ArrayList<PedidoDtoResource> getAllPedidos() {
    List<Pedido> pedidos = pedidoDao.findAll();
    ArrayList<PedidoDtoResource> pedidoDtoResources = new ArrayList<>();
    pedidos.forEach(p->{
      pedidoDtoResources.add( new PedidoDtoResource(new ClienteDtoSemSenha(p.getCliente().getNome(),p.getCliente().getSobrenome(), p.getCliente().getEmail(), 
      p.getCliente().getSexo(), p.getCliente().getCpf(),
       p.getCliente().getPerfilEnum().toString()), p.getProdutos()));
    });
    return pedidoDtoResources;
  }

  @Override
  public PedidoDtoResource getPedidoById(Long id) {
    Optional<Pedido> pedidoOptional = pedidoDao.findById(id);
    if (pedidoOptional.isEmpty()) {
      throw new EcommerceException("Pedido inexistente", 404);
    }
    return new PedidoDtoResource(new ClienteDtoSemSenha(pedidoOptional.get().getCliente().getNome(),pedidoOptional.get().getCliente().getSobrenome(), pedidoOptional.get().getCliente().getEmail(), 
    pedidoOptional.get().getCliente().getSexo(), pedidoOptional.get().getCliente().getCpf(),
     pedidoOptional.get().getCliente().getPerfilEnum().toString()), pedidoOptional.get().getProdutos());
  }

}
