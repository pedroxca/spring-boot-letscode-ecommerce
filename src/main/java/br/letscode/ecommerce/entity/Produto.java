package br.letscode.ecommerce.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
  @Id
  private Long id;
  @Column(name = "name")
  private String name;
  @Column(name = "price", columnDefinition = "DECIMAL(4,2)")
  private BigDecimal price;

  @Column(name = "description")
  private String description;

  public Produto(Long id, String name, BigDecimal price, String description) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public Produto(String name, BigDecimal price, String description) {
    this.name = name;
    this.price = price;
    this.description = description;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
