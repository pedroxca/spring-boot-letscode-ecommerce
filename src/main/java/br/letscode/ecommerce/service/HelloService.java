package br.letscode.ecommerce.service;

import br.letscode.ecommerce.models.Message;

public interface HelloService {
  public Message helloWorld();

  public Message helloUser(String user);

  public Message helloUserTime(String user);
}
