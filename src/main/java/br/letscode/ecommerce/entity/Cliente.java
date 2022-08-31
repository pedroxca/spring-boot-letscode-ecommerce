package br.letscode.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nome")
  private String nome;
  @Column(name = "sobrenome")
  private String sobrenome;
  @Column(name = "email")
  private String email;
  @Column(name = "sexo")
  private String sexo;
  @Column(name = "cpf", unique = true)
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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobreNome() {
    return sobrenome;
  }

  public void setSobreNome(String sobreNome) {
    this.sobrenome = sobreNome;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSexo() {
    return sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  @Override
  public String toString() {
    // Long id, String nome, String sobrenome, String email, String sexo, String cpf
    return String.format("{id=%s, nome=%s, sobrenome=%s, email=%s, sexo=%s, cpf=%s}", id, nome, sobrenome, email, sexo,
        cpf);

  }
}
