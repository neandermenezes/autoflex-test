# Autoflex-app
Feito com React, ContextAPI, Javascript, Java, Quarkus, Hibernate e MYSQL.

## Descrição

Front-end possui 3 telas principais, Produtos, Matérias primas e ProdutosMatériasPrimas.

- A tela de produtos possui uma tabela com todos produtos do banco de dados e um form para criação de novos produtos.
- A tela de Matérias primas possui uma tabela com todas matérias primas e um form para criação de novas matérias primas.
- A tela de ProdutosMatériasPrimas possui uma tabela com cards, cada card é referente a uma matéria prima, este card contém todos produtos que aquela matéria prima pode construir.

Back-end possui 2 rotas principais: "/product" e "/feedstock"

A entidade Product recebe os seguintes atributos:
  ID BIGINT
  NAME VARCHAR
  VALUE INT
  
A entidade Feedstock recebe os seguintes atributos:
  ID BIGINT
  NAME VARCHAR
  QUANTITY INT
  
Há também uma terceira tabela construida a partir de Product e Feedstock (product_feedstock) que faz uma relação many to mano.

- Product possui um CRUD básico
- Feedstock possui um CRUD básico e uma raw query na rota "/feedstock/products" para retornar todos produtos que uma certa matéria prima pode produzer.

## Como usar esse repositório
- Clone o repositório
- Entre no terminal da pasta autoflex-back baixe as dependencias com mvn install e rode quarkus dev.
- Entre no terminal da pasta autoflex-front baixe as dependencias com npm install e rode npm start.
- Agora voce deve estar com a aplicação rodando nas portas 3000 (front) e 8080 (back), caso contrário rode os comandos (linux):
- sudo kill -9 `sudo lsof -t -i:8080`
- sudo kill -9 `sudo lsof -t -i:3000`
- NÃO ESQUEÇA DE MUDAR AS VARIAVEIS DO SEU BANCO MYSQL EM: MAIN/RESOURCES/APPLICATION.PROPERTIES



