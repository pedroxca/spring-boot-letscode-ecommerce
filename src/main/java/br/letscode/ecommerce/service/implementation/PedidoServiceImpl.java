package br.letscode.ecommerce.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.letscode.ecommerce.dao.ClienteDao;
import br.letscode.ecommerce.dao.PedidoDao;
import br.letscode.ecommerce.dao.ProdutoDao;
import br.letscode.ecommerce.dto.PedidoDto;
import br.letscode.ecommerce.entity.Cliente;
import br.letscode.ecommerce.entity.Pedido;
import br.letscode.ecommerce.entity.Produto;
import br.letscode.ecommerce.exceptions.EcommerceException;
import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.PedidoService;

@Service
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
    Optional<Cliente> cliente = clienteDao.findById(pedidoDto.getClientId());
    listOfProdutosOptional.stream().forEach(produto -> {
      if (!(produto.isPresent()) || !(cliente.isPresent())) {
        throw new EcommerceException("Cliente e/ou produto não existem", 400);
      }
    });
    List<Produto> produtos = listOfProdutosOptional.stream().map(p -> p.get()).collect(Collectors.toList());
    Pedido pedido = new Pedido(false, false, cliente.get(), produtos, LocalDateTime.now());
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
  public List<Pedido> getAllPedidos() {
    return pedidoDao.findAll();
  }

  @Override
  public Pedido getPedidoById(Long id) {
    Optional<Pedido> pedidoOptional = pedidoDao.findById(id);
    if (pedidoOptional.isEmpty()) {
      throw new EcommerceException("Pedido inexistente", 404);
    }
    return pedidoOptional.get();
  }

}
