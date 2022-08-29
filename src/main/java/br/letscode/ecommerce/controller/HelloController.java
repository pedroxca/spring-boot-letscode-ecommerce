package br.letscode.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @Autowired
  HelloService helloWorldService;

  Logger log = LoggerFactory.getLogger(HelloController.class);

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Message> helloWorld() {
    log.error("Inserção feita com sucesso");
    return ResponseEntity.status(HttpStatus.OK).body(helloWorldService.helloWorld());
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{user}")
  public ResponseEntity<Message> helloUser(@PathVariable String user) {
    return ResponseEntity.status(HttpStatus.OK).body(helloWorldService.helloUser(user));
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{user}/horario")
  public ResponseEntity<Message> helloUserTime(@PathVariable String user) {
    return ResponseEntity.status(HttpStatus.OK).body(helloWorldService.helloUserTime(user));
  }
}
