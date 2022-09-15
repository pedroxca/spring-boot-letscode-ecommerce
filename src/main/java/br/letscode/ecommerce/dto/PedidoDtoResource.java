package br.letscode.ecommerce.dto;

import java.util.List;

import br.letscode.ecommerce.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDtoResource {
  private ClienteDtoSemSenha clienteDtoSemSenha;
  private List<Produto> produtosList;
}
