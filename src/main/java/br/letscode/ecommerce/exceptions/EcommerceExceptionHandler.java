package br.letscode.ecommerce.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.letscode.ecommerce.errors.ErrorMessage;

@RestControllerAdvice
public class EcommerceExceptionHandler {
  @ExceptionHandler(EcommerceException.class)
  public ResponseEntity<ErrorMessage> toResponse(EcommerceException ex) {
    ErrorMessage errorMessage = new ErrorMessage(ex.getCode(),
        ex.getClass().getSimpleName() + ": " + ex.getMessage());
    return ResponseEntity.status(ex.getCode()).body(errorMessage);
  }
}