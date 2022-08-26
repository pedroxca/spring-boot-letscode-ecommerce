package br.letscode.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.letscode.ecommerce.models.HelloWorld;
import br.letscode.ecommerce.service.HelloWorldService;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

  @Autowired
  HelloWorldService helloWorldService;

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<HelloWorld> helloWorld() {
    return ResponseEntity.status(HttpStatus.OK).body(helloWorldService.helloWorld());
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{user}")
  public ResponseEntity<HelloWorld> helloWorldUser(@PathVariable String user) {
    return ResponseEntity.status(HttpStatus.OK).body(helloWorldService.helloWorld(user));
  }

  @RequestMapping(method = RequestMethod.GET, path = "/{user}/horario")
  public ResponseEntity<HelloWorld> helloWorldUserTime(@PathVariable String user) {
    return ResponseEntity.status(HttpStatus.OK).body(helloWorldService.helloWorldTime(user));
  }
}
