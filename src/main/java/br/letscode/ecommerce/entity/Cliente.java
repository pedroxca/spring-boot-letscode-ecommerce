package br.letscode.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@NonNull
@Getter
@Setter
@Entity
@Table(name = "cliente")
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

  public Cliente(Long id, String nome, String sobrenome, String email, String sexo, String cpf) {
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.email = email;
    this.sexo = sexo;
    this.cpf = cpf;
  }

  public Cliente(String nome, String sobreNome, String email, String sexo, String cpf) {
    this.nome = nome;
    this.sobrenome = sobreNome;
    this.email = email;
    this.sexo = sexo;
    this.cpf = cpf;
  }

  public Cliente() {
  }



  @Override
  public String toString() {
    // Long id, String nome, String sobrenome, String email, String sexo, String cpf
    return String.format("{id=%s, nome=%s, sobrenome=%s, email=%s, sexo=%s, cpf=%s}", id, nome, sobrenome, email, sexo,
        cpf);

  }
}
