package br.letscode.ecommerce.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.letscode.ecommerce.models.Message;

@RestController
@RequestMapping(path = "/home", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiHomeController {
  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Message> home(){
    return ResponseEntity.ok(new Message("Hello, this is the API home!"));
  }
}
