
CREATE TABLE IF NOT EXISTS cliente (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  sobrenome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  sexo VARCHAR(255) NOT NULL,
  cpf VARCHAR(255) NOT NULL
);

INSERT INTO cliente VALUES(1, 'Pedro', 'Faustino', 'email.email@gmail.com', 'MASC', '11110211111');