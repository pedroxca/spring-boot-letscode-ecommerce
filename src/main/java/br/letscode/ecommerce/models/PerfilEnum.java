package br.letscode.ecommerce.models;

import java.util.List;

import br.letscode.ecommerce.exceptions.EcommerceException;
public enum PerfilEnum {
  ADMIN("ADMIN"),
  CLIENTE("CLIENTE");

  private String perfil;

  PerfilEnum(String perfil) {
    this.perfil = perfil;
  }

  public String getPerfil() {
    return perfil;
  }

  public static PerfilEnum valorDePerfilEnum(String perfil) {
    for (PerfilEnum perfilEnum : PerfilEnum.values()) {
      if (perfilEnum.toString().equals(perfil)) {
        System.out.println(perfil);
        System.out.println(perfilEnum.toString());
        return perfilEnum;
      }
    }
    throw new EcommerceException("Esse perfil não existe, por favor, tente em algum destes perfis: " + List.of(PerfilEnum.values()).toString(), 400);
  }
}
