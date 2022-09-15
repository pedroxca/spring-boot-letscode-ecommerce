CREATE TABLE IF NOT EXISTS cliente (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  sobrenome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  sexo VARCHAR(255) NOT NULL,
  cpf VARCHAR(255) NOT NULL UNIQUE,
  senha VARCHAR(255) NOT NULL,
  perfil_enum VARCHAR(255) not null
);
CREATE TABLE IF NOT EXISTS produto (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  preco DECIMAL(7, 2) NOT NULL,
  descricao VARCHAR(255) NOT NULL
);
-- private Long id;
--   @Column(name = "cancelado")
--   private Boolean cancelado;
--   @Column(name = "terminado")
--   private Boolean terminado;
--   @Column(name = "data_pedido")
--   private LocalDateTime dataPedido;
--   @Column(name = "data_terminado")
--   private LocalDateTime dataTerminado;
--   @OneToOne(fetch = FetchType.LAZY)
--   @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false)
--   private Cliente cliente;
--   @JoinColumn(name = "produto_id", referencedColumnName = "pid")
--   @ManyToMany(fetch = FetchType.LAZY)
-- private List < Produto > produtos;
-- CREATE TABLE IF NOT EXISTS pedido (
--   id INTEGER PRIMARY KEY AUTO_INCREMENT,
--   nome VARCHAR(255) NOT NULL,
--   preco DECIMAL(7, 2) NOT NULL,
--   descricao VARCHAR(255) NOT NULL
-- );
INSERT INTO cliente
VALUES(
    1,
    'Pedro',
    'Faustino',
    'email.email@gmail.com',
    'MASCULINO',
    '11110211111',
    '$2a$12$Wr.nmhjxY9e7cFTNZrtW7eSS9I6kFucqIU8PQwjbSiOGY2pLcD/fi',
    'ADMIN'
  );
INSERT INTO cliente
VALUES(
    2,
    'Pedro',
    'Matias',
    'email.email@hotmail.com',
    'MASCULINO',
    '11111111111',
    '$2a$12$Wr.nmhjxY9e7cFTNZrtW7eSS9I6kFucqIU8PQwjbSiOGY2pLcD/fi',
    'CLIENTE'
  );
INSERT INTO produto
VALUES(
    1,
    'Gluten Free Bread',
    72.5,
    'This is a gluten free bread'
  );
INSERT INTO produto
VALUES(2, 'Bread', 1, 'This is not a gluten free bread');