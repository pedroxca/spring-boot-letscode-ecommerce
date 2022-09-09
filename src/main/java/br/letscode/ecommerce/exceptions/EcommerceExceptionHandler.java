package br.letscode.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.letscode.ecommerce.errors.ErrorMessage;

@RestControllerAdvice
public class EcommerceExceptionHandler {
  @ExceptionHandler(EcommerceException.class)
  public ResponseEntity<ErrorMessage> toResponseGeneral(EcommerceException ex) {
    ErrorMessage errorMessage = new ErrorMessage(ex.getStatus(), ex.getMessage(), ex.getClass().getSimpleName());
    return ResponseEntity.status(ex.getStatus()).body(errorMessage);
  }
  @ExceptionHandler(InvalidCpfException.class)
  @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "O cpf foi digitado incorretamente seguindo os padrões")
  public ResponseEntity<ErrorMessage> toResponseInvalidCpf(EcommerceException ex) {
    ErrorMessage errorMessage = new ErrorMessage(ex.getStatus(), ex.getMessage(), ex.getClass().getSimpleName());
    return ResponseEntity.status(ex.getStatus()).body(errorMessage);
  }
}
