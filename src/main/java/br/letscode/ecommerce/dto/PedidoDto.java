package br.letscode.ecommerce.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
  private Long clientId;
  private List<Long> produtoIds;
}
