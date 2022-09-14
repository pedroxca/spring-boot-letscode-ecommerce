package br.letscode.ecommerce.dto;

import br.letscode.ecommerce.models.Cpf;
import br.letscode.ecommerce.models.PerfilEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDtoSemSenha {

  private String nome;
  private String sobrenome;
  private String email;
  private String sexo;
  private String cpf;
  private PerfilEnum perfilEnum;

  public ClienteDtoSemSenha(String nome, String sobrenome, String email, String sexo, String cpf,
      String perfilEnum) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.email = email;
    this.sexo = sexo;
    this.cpf = cpf;
    this.perfilEnum = PerfilEnum.valorDePerfilEnum(perfilEnum);
  }

  public void setCpf(String cpf) {
    this.cpf = Cpf.createCPF(cpf);
  }
}
