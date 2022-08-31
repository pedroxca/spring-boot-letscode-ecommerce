package br.letscode.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCpfException extends EcommerceException {
  private String msg;
  private int code;
  public InvalidCpfException(String msg, int code) {
    super(msg, code);
  }
  @Override
  public String getMessage() {
    return super.getMessage();
  }
  @Override
  public int getCode() {
    return super.getCode();
  }
}
