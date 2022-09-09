package br.letscode.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.letscode.ecommerce.errors.ErrorMessage;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class GeneralExceptionHandler {
  @ExceptionHandler(Exception.class)
  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ErrorMessage> toResponse(Exception ex) {
    ErrorMessage errorMessage = new ErrorMessage(500, ex.getMessage(), ex.getClass().getSimpleName());
    return ResponseEntity.status(500).body(errorMessage);
  }
}
