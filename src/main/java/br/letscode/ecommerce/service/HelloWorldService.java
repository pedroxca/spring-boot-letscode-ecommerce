package br.letscode.ecommerce.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.letscode.ecommerce.models.HelloWorld;

@Service
public class HelloWorldService {

  public HelloWorld helloWorld() {
    return new HelloWorld("Hello world!");
  }

  public HelloWorld helloWorld(String user) {
    return new HelloWorld("Hello " + user + "!");
  }

  public HelloWorld helloWorldTime(String user) {
    LocalDateTime now = LocalDateTime.now();
    return new HelloWorld("Hello " + user + "!" + " Agora são: " + now.getHour() + ":" + now.getMinute());
  }
}
