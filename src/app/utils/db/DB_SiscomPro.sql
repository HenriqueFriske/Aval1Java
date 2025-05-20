/**
 * Author:  Eldair
 * Created: 10 de mai. de 2025
 */


/***** TABELA CLIENTES *****/
DROP TABLE tb_clientes IF EXISTS;

CREATE TABLE tb_clientes (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  email VARCHAR(100) NOT NULL,
  homePhone VARCHAR(20),
  cellPhone VARCHAR(20) NOT NULL,
  zipCode VARCHAR(10),
  address VARCHAR(150),
  number VARCHAR(10),
  neighborhood VARCHAR(50),
  city VARCHAR(50),
  uf CHAR(2)
);

-- Inserção de registros (valores de 'number' entre aspas)
INSERT INTO tb_clientes (name, cpf, email, homePhone, cellPhone, zipCode, address, number, neighborhood, city, uf) VALUES
('Ana Silva','12345678900','ana.silva@email.com','1133224455','11987654321','01001000','Rua das Flores','123','Centro','São Paulo','SP'),
('Bruno Souza','23456789011','bruno.souza@email.com','1133224466','11987654322','02002000','Av. Paulista','456','Bela Vista','São Paulo','SP'),
('Carlos Lima','34567890122','carlos.lima@email.com','1133224477','11987654323','03003000','Rua Augusta','789','Consolação','São Paulo','SP'),
('Daniela Rocha','45678901233','daniela.rocha@email.com','1133224488','11987654324','04004000','Av. Brasil','321','Jardins','São Paulo','SP'),
('Eduardo Reis','56789012344','eduardo.reis@email.com','1133224499','11987654325','05005000','Rua XV de Novembro','654','Centro','Campinas','SP'),
('Fernanda Costa','67890123455','fernanda.costa@email.com','1133224400','11987654326','06006000','Av. Independência','987','Bosque','Campinas','SP'),
('Gustavo Almeida','78901234566','gustavo.almeida@email.com','1133224411','11987654327','07007000','Rua São João','111','Centro','Santos','SP'),
('Helena Nunes','89012345677','helena.nunes@email.com','1133224422','11987654328','08008000','Av. Afonso Pena','222','Boqueirão','Santos','SP'),
('Igor Martins','90123456788','igor.martins@email.com','1133224433','11987654329','09009000','Rua General Osório','333','Vila Belmiro','Santos','SP'),
('Julia Fernandes','01234567899','julia.fernandes@email.com','1133224444','11987654330','10010000','Av. Rio Branco','444','Centro','Ribeirão Preto','SP'),
('Kaio Pereira','11122233344','kaio.pereira@email.com','1133224455','11987654331','11011000','Rua Dom Pedro','555','Jardim América','Ribeirão Preto','SP'),
('Larissa Teixeira','22233344455','larissa.teixeira@email.com','1133224466','11987654332','12012000','Av. das Américas','666','Zona Sul','Rio de Janeiro','RJ'),
('Marcelo Oliveira','33344455566','marcelo.oliveira@email.com','1133224477','11987654333','13013000','Rua do Catete','777','Glória','Rio de Janeiro','RJ'),
('Natália Ribeiro','44455566677','natalia.ribeiro@email.com','1133224488','11987654334','14014000','Av. Presidente Vargas','888','Centro','Rio de Janeiro','RJ'),
('Otávio Gomes','55566677788','otavio.gomes@email.com','1133224499','11987654335','15015000','Rua Voluntários','999','Botafogo','Rio de Janeiro','RJ'),
('Paula Mendes','66677788899','paula.mendes@email.com','1133224400','11987654336','16016000','Av. Copacabana','101','Copacabana','Rio de Janeiro','RJ'),
('Rafael Lima','77788899900','rafael.lima@email.com','1133224411','11987654337','17017000','Rua da Paz','202','Centro','Curitiba','PR'),
('Sabrina Lopes','88899900011','sabrina.lopes@email.com','1133224422','11987654338','18018000','Av. Sete de Setembro','303','Batel','Curitiba','PR'),
('Thiago Silva','99900011122','thiago.silva@email.com','1133224433','11987654339','19019000','Rua Marechal Floriano','404','Centro','Porto Alegre','RS'),
('Vanessa Carvalho','00011122233','vanessa.carvalho@email.com','1133224444','11987654340','20020000','Av. Ipiranga','505','Cidade Baixa','Porto Alegre','RS');
select * from tb_clientes; 

