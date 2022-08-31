package br.letscode.ecommerce.exceptions;

public class EcommerceException extends RuntimeException {
  private String msg;
  private int code;
  public EcommerceException() {
  }

  public EcommerceException(String msg, int code) {
    this.msg = msg;
    this.code = code;
  }
  @Override
  public String getMessage() {
    return msg;
  }
  public int getCode() {
    return code;
  }
}
