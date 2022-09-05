package br.letscode.ecommerce.ApiHomeTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import br.letscode.ecommerce.controller.api.v1.ApiHomeController;
import br.letscode.ecommerce.models.Message;

@SpringBootTest
public class ApiHomeTest {

  @Autowired
  ApiHomeController apiHomeController;
  @Test
  public void apiHomeShouldReturnDefaultMessage() {
    ResponseEntity<Message> result = apiHomeController.home();
    assertEquals(result.getBody().getMessage(), "Hello, this is the API home!");
  }
}
