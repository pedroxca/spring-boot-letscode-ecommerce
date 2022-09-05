package br.letscode.ecommerce.models;

import java.util.regex.Pattern;

import br.letscode.ecommerce.exceptions.InvalidCpfException;
import lombok.NonNull;

@NonNull
public final class Cpf {
  private String cpfString;
  private static final String CPF_MATCHER_STRING = "^[0-9]{11}$";

  private Cpf(String cpf) {
    validaCpf(cpf);
    this.cpfString = cpf;
  }

  private String getCpfString() {
    return cpfString;
  }

  private void setCpfString(String cpfString) {
    validaCpf(cpfString);
    this.cpfString = cpfString;
  }

  public static void validaCpf(String cpf) {
    if (!Pattern.matches(CPF_MATCHER_STRING, cpf)) {
      throw new InvalidCpfException("CPF invalido", 400);
    }
    Integer soma = cpf.chars().sum();
    if (soma % 11 != 0) {
      throw new InvalidCpfException("CPF invalido", 400);
    }
  }

  public static final String createCPF(String s) {
    Cpf c = new Cpf(s);
    return c.getCpfString();
  }

  @Override
  public String toString() {
    return cpfString;
  }
}