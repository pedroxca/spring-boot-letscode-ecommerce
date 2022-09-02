package br.letscode.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCpfException extends EcommerceException {
  public InvalidCpfException(String message, int code) {
    super(message, code);
  }
  @Override
  public String getMessage() {
    return super.getMessage();
  }
  @Override
  public int getStatus() {
    return super.getStatus();
  }
}
