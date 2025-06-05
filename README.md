 # DSCommerce API 🛍️

Backend para a aplicação de e-commerce DSCommerce, construído com Java, Spring Boot, Spring Data JPA e protegido com Spring Security (OAuth2 + JWT).

## Visão Geral

Este projeto fornece os serviços de backend para uma plataforma de e-commerce, incluindo gerenciamento de produtos e usuários, com um sistema de autenticação e autorização robusto baseado no Spring Security e JWT.

## Funcionalidades Principais ✨

* **Gerenciamento de Produtos:** CRUD completo com validações.
* **Consulta de Usuários:** Endpoint para dados do usuário logado.
* **Segurança:**
    * Autorização baseada em roles (admin e cliente).
    * Tokens JWT para acesso à API.
* **Tratamento de Erros:** Respostas de erro padronizadas.

## Pré-requisitos 📋

* JDK 17+
* Maven ou Gradle
* Ferramenta para teste de API (ex: Postman)

## Como Executar 🚀
* Clone: git clone https://github.com/Raflit0s/e-commerce
* Navegue: cd dscommerce
* Execute (Maven): mvn spring-boot:run
* A API estará em http://localhost:8080.
* O H2 Console (se perfil test ativo) em http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:testdb).

## Autenticação (Obter Token) 🔑

Envie uma requisição POST para http://localhost:8080/oauth2/token

* Authorization= Auth type: Basic Auth (username, password)
* Corpo (form-urlencoded): username, password, grant_type
* grant_type=password
* username=alex@gmail.com ou maria@gmail.com
* password=123456 (para ambos)
* O servidor retornará um access_token (JWT). Use este token no Authorization: Auth type: Bearer para requisições autenticadas.

## Principais Endpoints da API 🌐
* **Autenticação:**
* POST /oauth2/token: Obter token de acesso.
* **Produtos (/products):**
* GET /: Lista produtos (público).
* GET /{id}: Detalhes do produto (público).
* POST /: Cria produto (ROLE_ADMIN).
* PUT /{id}: Atualiza produto (ROLE_ADMIN).
* DELETE /{id}: Deleta produto (ROLE_ADMIN).
* **Usuários (/users):**
* GET /me: Dados do usuário logado (ROLE_ADMIN, ROLE_CLIENT).
