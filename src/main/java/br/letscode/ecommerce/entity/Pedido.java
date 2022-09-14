package br.letscode.ecommerce.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
public class Pedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "cancelado")
  private Boolean cancelado;
  @Column(name = "terminado")
  private Boolean terminado;
  @Column(name = "data_pedido")
  private LocalDateTime dataPedido;
  @Column(name = "data_terminado")
  private LocalDateTime dataTerminado;


  @OneToOne
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Cliente cliente;

  @JoinColumn(name = "produto_id", referencedColumnName = "pid")
  @ManyToMany
  private List<Produto> produtos;

  public Pedido(Boolean cancelado, Boolean terminado, Cliente cliente, List<Produto> produtos, LocalDateTime dataInicio) {
    this.cancelado = cancelado;
    this.terminado = terminado;
    this.cliente = cliente;
    this.produtos = produtos;
  }
  
}