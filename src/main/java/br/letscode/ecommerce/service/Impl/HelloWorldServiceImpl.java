package br.letscode.ecommerce.service.Impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.letscode.ecommerce.models.HelloWorld;
import br.letscode.ecommerce.service.HelloWorldService;


@Service
public class HelloWorldServiceImpl implements HelloWorldService {

  @Override
  public HelloWorld helloWorld() {
    return new HelloWorld("Hello world!");
  }

  @Override
  public HelloWorld helloWorld(String user) {
    return new HelloWorld("Hello " + user + "!");
  }

  @Override
  public HelloWorld helloWorldTime(String user) {
    LocalDateTime now = LocalDateTime.now();
    return new HelloWorld("Hello " + user + "!" + " Agora são: " + now.getHour() + ":" + now.getMinute());
  }
}
