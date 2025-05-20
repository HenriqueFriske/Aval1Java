/**
 * Author:  Eldair
 * Created: 10 de mai. de 2025
 */



/***** TABELA CLIENTES *****/
-- DROP TABLE tb_clientes;
CREATE TABLE tb_clientes (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  nome varchar(100),
  cpf varchar (20),
  email varchar(200),  
  telefone varchar(30),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  numero int,
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2),
  PRIMARY KEY (id)
);
/*****************/

/***** TABELA FORNECEDORES *****/
-- DROP TABLE tb_fornecedores;
CREATE TABLE tb_fornecedores (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  nome varchar(100),
  cnpj varchar (100),
  email varchar(200),
  telefone varchar(30),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  numero int,
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2),
  PRIMARY KEY (id)
);
/*****************/

/***** TABELA FUNCIONARIOS *****/
-- DROP TABLE tb_funcionarios;
CREATE TABLE tb_funcionarios (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  nome varchar(100),
  rg varchar (30),
  cpf varchar (20),
  email varchar(200),
  senha varchar(10),
  cargo varchar(100),
  nivel_acesso varchar(50),
  telefone varchar(30),
  celular varchar(30),
  cep varchar(100),
  endereco varchar (255),
  numero int,
  bairro varchar (100),
  cidade varchar (100),
  estado varchar (2),
  PRIMARY KEY (id)
);
/*****************/


/***** TABELA PRODUTOS *****/
-- DROP TABLE tb_produtos
CREATE TABLE tb_produtos (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  descricao varchar(100),
  preco decimal (10,2),
  qtd_estoque int,
  fornecedor_id int,
  PRIMARY KEY (id),
  CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES tb_fornecedores(id)
);
/*****************/

/***** TABELA VENDAS *****/
-- DROP TABLE tb_vendas;
CREATE TABLE tb_vendas (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  cliente_id int,
  funcionario_id int,
  data_venda TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  total_venda decimal (10,2),
  observacoes LONG VARCHAR,
  CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES tb_clientes(id),
  CONSTRAINT fk_funcionario FOREIGN KEY (funcionario_id) REFERENCES tb_funcionarios(id),
  PRIMARY KEY (id)
);
/*****************/

/***** TABELA ITENS_VENDAS *****/
-- DROP TABLE tb_itensvendas;
CREATE TABLE tb_itensvendas (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  venda_id int,
  produto_id int,
  qtd int,
  subtotal decimal (10,2),
  CONSTRAINT fk_venda FOREIGN KEY (venda_id) REFERENCES tb_vendas(id),
  CONSTRAINT fk_produto FOREIGN KEY (produto_id) REFERENCES tb_produtos(id),
  PRIMARY KEY (id)
);
/*****************/

/******* APAGAR TODAS AS TABELAS **********/
 
-- DROP TABLE tb_itensvendas;
-- DROP TABLE tb_vendas;
-- DROP TABLE tb_funcionarios;
-- DROP TABLE tb_produtos;
-- DROP TABLE tb_fornecedores;
-- DROP TABLE tb_clientes;

        
SELECT * FROM tb_clientes WHERE LOWER(nome) LIKE LOWER('%Mariana %');
select * from tb_clientes where LOWER(nome) like LOWER(?); 
