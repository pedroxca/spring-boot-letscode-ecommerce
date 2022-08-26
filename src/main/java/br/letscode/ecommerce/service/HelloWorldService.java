package br.letscode.ecommerce.service;

import br.letscode.ecommerce.models.HelloWorld;

public interface HelloWorldService {
  public HelloWorld helloWorld();

  public HelloWorld helloWorld(String user);

  public HelloWorld helloWorldTime(String user);
}
