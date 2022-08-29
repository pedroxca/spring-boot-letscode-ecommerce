package br.letscode.ecommerce.service.implementation;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.letscode.ecommerce.models.Message;
import br.letscode.ecommerce.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService {

  @Override
  public Message helloWorld() {
    return new Message("Hello world!");
  }

  @Override
  public Message helloUser(String user) {
    return new Message("Hello " + user + "!");
  }

  @Override
  public Message helloUserTime(String user) {
    LocalDateTime now = LocalDateTime.now();
    return new Message(
        "Hello " + user + "!" + " Agora são: " + now.getHour() + ":" + now.getMinute() + ", não se esqueça!");
  }
}
