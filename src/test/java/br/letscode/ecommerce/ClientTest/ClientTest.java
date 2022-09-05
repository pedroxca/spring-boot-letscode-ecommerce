package br.letscode.ecommerce.ClientTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.letscode.ecommerce.controller.api.v1.ClienteController;
import br.letscode.ecommerce.entity.Cliente;

@SpringBootTest
public class ClientTest {
  @Autowired
  ClienteController clienteController;

  @Mock
  RestTemplate restTemplate;

  @Test
  public void testItShouldGetAllClientsEmpty() {
    // Cliente c = new Cliente(1L, "Pedro", "Faustino", "email.email@email.com",
    // "MASC", "11111111111");
    List<Cliente> listExpected = new ArrayList<>();
    @SuppressWarnings("")
    Class<List<Cliente>> classTypeClass = (Class<List<Cliente>>) (Class<?>) List.class;
    Mockito.when(restTemplate.getForEntity("http://localhost:8080/api/v1/cliente", classTypeClass))
        .thenReturn(new ResponseEntity<List<Cliente>>(listExpected, HttpStatus.OK));
    ResponseEntity<List<Cliente>> listResult = clienteController.getClients();
    Assertions.assertEquals(listExpected, listResult.getBody());
  }
}
