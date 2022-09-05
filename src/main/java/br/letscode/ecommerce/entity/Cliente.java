package br.letscode.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.letscode.ecommerce.models.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NonNull
@Getter
@Setter
@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(name = "Cliente.findByCPF", query = "SELECT * FROM cliente WHERE cpf = ?1", resultClass = Cliente.class)
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome", nullable = false)
  private String nome;
  @Column(name = "sobrenome", nullable = false)
  private String sobrenome;
  @Column(name = "email", nullable = false)
  private String email;
  @Column(name = "sexo", nullable = false)
  private String sexo;
  @Column(name = "cpf", unique = true, nullable = false)
  private String cpf;
  @JsonIgnore
  @Column(name = "senha", nullable = false)
  private String senha;
  @Column(name = "perfil_enum")
  @Enumerated(EnumType.STRING)
  private PerfilEnum perfilEnum;

  public Cliente(String nome, String sobreNome, String email, String sexo, String cpf, String senha, PerfilEnum perfilEnum) {
    this.nome = nome;
    this.sobrenome = sobreNome;
    this.email = email;
    this.sexo = sexo;
    this.cpf = cpf;
    this.senha = senha;
    this.perfilEnum = perfilEnum;
  }
  public Cliente(Long id, String nome, String sobreNome, String email, String sexo, String cpf, String senha, String perfilEnum) {
    this.nome = nome;
    this.sobrenome = sobreNome;
    this.email = email;
    this.sexo = sexo;
    this.cpf = cpf;
    this.senha = senha;
    this.perfilEnum = perfilEnum;
  }

  public Cliente(Long id, String nome, String sobreNome, String email, String sexo, String cpf) {
    
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobreNome;
    this.email = email;
    this.sexo = sexo;
    this.cpf = cpf;
  }

  @Override
  public String toString() {
    // Long id, String nome, String sobrenome, String email, String sexo, String cpf
    return String.format("{id=%s, nome=%s, sobrenome=%s, email=%s, sexo=%s, cpf=%s, role=%s}", id, nome, sobrenome, email, sexo,
        cpf, perfilEnum.name());

  }
}
