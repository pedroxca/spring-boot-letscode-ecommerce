package br.letscode.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.letscode.ecommerce.dto.ClienteDto;
import br.letscode.ecommerce.entity.Cliente;
import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.ClienteService;

@RestController
@RequestMapping(path = "/api/v1/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

  @Autowired
  ClienteService clienteService;

  Logger log = LoggerFactory.getLogger(ClienteController.class);

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<List<Cliente>> getClients() {
    return ResponseEntity.status(HttpStatus.OK).body(clienteService.getAllClients());
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{cpf}")
  public ResponseEntity<Cliente> getClientByCPF(@PathVariable String cpf) {
    return ResponseEntity.status(HttpStatus.OK).body(clienteService.findByCpf(cpf));
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Message> createClient(@RequestBody ClienteDto clienteDto) {
    return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.novoCliente(clienteDto));
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Message> deleteClient(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(clienteService.removerCliente(id));
  }

  @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Message> updateClient(@RequestBody ClienteDto cliente, @PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(clienteService.atualizarCliente(cliente, id));
  }
}
