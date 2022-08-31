package br.letscode.ecommerce.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
  private String message;

  public Message(String msg) {
    this.message = msg;
  }

}
