package br.letscode.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class TokenDto {
  private String email;
  private String token;
}
