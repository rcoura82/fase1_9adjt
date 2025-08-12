CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255),
    login VARCHAR(255),
    senha VARCHAR(255),
    data_ultima_alteracao TIMESTAMP,
    endereco VARCHAR(255)
);