package br.letscode.ecommerce.exceptions;

public class EcommerceException extends RuntimeException {
  private String message;
  private int status;
  public EcommerceException() {
  }

  public EcommerceException(String message, int status) {
    this.message = message;
    this.status = status;
  }
  @Override
  public String getMessage() {
    return message;
  }
  public int getStatus() {
    return status;
  }
}
