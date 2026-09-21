# Lab 3 — JPA e Docker

Template de partida para o **Lab 3** de Distributed Systems 2026/27.

Vais mover a API do Product para uma base de dados PostgreSQL a sério, gerir o esquema com o Flyway, e correr tudo em containers.

## A usar este template

Carrega em **Use this template → Create a new repository** no GitHub. Dá-lhe o nome
`lab-03-jpa-docker-aXXXXXXXX` com o teu número de aluno.
Não faças fork, e não clones este repositório diretamente — precisas do teu próprio histórico.

## O que está aqui

O scaffolding: o POM com todas as dependências de que o lab precisa, a estrutura de packages,
a configuração, e a preparação do container. Constrói e arranca tal como está.

## O que não está aqui

A entidade `Product`, o repository, o service e o controller. A migração `V1__create_product_table.sql` **está** incluída, para veres a convenção de nomes — a tabela que ela cria é a que a tua entidade tem de corresponder.

Isso é deliberado. Um template é um ponto de partida, não a resposta.

## A correr

```bash
cp .env.example .env
docker compose up --build
# app       http://localhost:8181
# pgAdmin   http://localhost:7778  (connect to host `db` port 5432, not localhost)
```

## Versões

Java 25, Spring Boot 4.1.0, Maven 3.9.16. Vê
[Toolchain e versões](https://github.com/DistributedSystems-Lusofona27/course-docs/blob/main/toolchain-and-versions.md)
se algo não resolver — a maior parte dos problemas de versões nesta cadeira vêm de seguir
um tutorial escrito para o Spring Boot 3.
