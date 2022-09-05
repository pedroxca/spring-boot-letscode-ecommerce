package br.letscode.ecommerce.dto;

import br.letscode.ecommerce.models.Cpf;
import br.letscode.ecommerce.models.PerfilEnum;
import lombok.Data;


@Data
public class ClienteDtoComSenha {

  private String nome;
  private String sobrenome;
  private String email;
  private String sexo;
  private String cpf;
  private String senha;
  private PerfilEnum perfilEnum ;

  

  public ClienteDtoComSenha(String nome, String sobrenome, String email, String sexo, String cpf, String senha,
      PerfilEnum perfilEnum) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.email = email;
    this.sexo = sexo;
    this.cpf = cpf;
    this.senha = senha;
    this.perfilEnum = perfilEnum;
  }



  public void setCpf(String cpf) {
    this.cpf = Cpf.createCPF(cpf);
  }
}
