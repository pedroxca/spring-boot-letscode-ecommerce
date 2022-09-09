
CREATE TABLE IF NOT EXISTS user (
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
  preco DECIMAL(7,2) NOT NULL,
  descricao VARCHAR(255) NOT NULL 
);

INSERT INTO user VALUES(1, 'Pedro', 'Faustino', 'email.email@gmail.com', 'MASCULINO', '11110211111', '$2a$12$Wr.nmhjxY9e7cFTNZrtW7eSS9I6kFucqIU8PQwjbSiOGY2pLcD/fi', 'ADMIN');
INSERT INTO user VALUES(2, 'Pedro', 'Matias', 'email.email@hotmail.com', 'MASCULINO', '11111111111', '$2a$12$Wr.nmhjxY9e7cFTNZrtW7eSS9I6kFucqIU8PQwjbSiOGY2pLcD/fi', 'CLIENTE');
INSERT INTO produto VALUES(1, 'Gluten Free Bread', 72.5, 'This is a gluten free bread');
INSERT INTO produto VALUES(2, 'Bread', 1, 'This is not a gluten free bread');
