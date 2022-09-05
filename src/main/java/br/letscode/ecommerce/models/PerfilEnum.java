package br.letscode.ecommerce.models;

public enum PerfilEnum {
  ADMIN("ADMIN"),
  CLIENTE("CLIENTE");
  private String perfil;
  
  PerfilEnum(String perfil){
    this.perfil = perfil;
  }
  public String getPerfil() {
    return perfil;
  }
}
