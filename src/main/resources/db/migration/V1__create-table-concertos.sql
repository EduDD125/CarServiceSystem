CREATE TABLE concertos (
    id bigint NOT NULL AUTO_INCREMENT,
    dataentrada VARCHAR(10) NOT NULL,
    datasaida VARCHAR(10) NOT NULL,
    nome VARCHAR(40) NOT NULL,
    experiencia INT NOT NULL,
    marca VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    ano INT NOT NULL,

    primary key(id)
);