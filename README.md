# 💰 Salva Carteira

Sistema de gestão financeira pessoal desenvolvido como projeto final da disciplina de Linguagem de Programação Orientada a Objetos.

## 📋 Sobre o Projeto
O **Salva Carteira** é uma aplicação web que permite ao usuário controlar suas finanças de forma simples. Com ele, é possível registrar receitas e despesas, categorizar gastos e visualizar o saldo atual em um dashboard intuitivo.

## 🚀 Tecnologias Utilizadas
* **Java 21**
* **Spring Boot 3** (Web, Data JPA, Validation)
* **MySQL** (Banco de dados)
* **Thymeleaf** (Front-end)
* **Bootstrap 5** (Estilização)
* **Maven** (Gerenciamento de dependências)

## ⚙️ Funcionalidades
- [x] **Dashboard:** Visualização rápida de Receitas, Despesas e Saldo.
- [x] **Transações:** Cadastro (Create), Listagem (Read) e Exclusão (Delete) de movimentações financeiras.
- [x] **Categorias:** Gestão de categorias personalizadas para organização.
- [x] **Persistência:** Dados salvos em banco relacional MySQL.

## 📦 Como rodar o projeto

### Pré-requisitos
* Java JDK 17 ou superior instalado.
* MySQL instalado e rodando.

### Passo a passo
1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/salvacarteira.git](https://github.com/seu-usuario/salvacarteira.git)
    ```
2.  **Configure o Banco de Dados:**
    * Crie um banco de dados no MySQL chamado `salvacarteira`.
    * Verifique o arquivo `src/main/resources/application.properties` e ajuste seu usuário e senha do MySQL se necessário.
3.  **Execute a aplicação:**
    * Via VS Code: Abra `SalvacarteiraApplication.java` e clique em "Run".
    * Via Terminal: `mvn spring-boot:run`
4.  **Acesse:**
    * Abra o navegador em `http://localhost:8080`

## 👨‍💻 Desenvolvedor
**Bruno Nogueira Alves Ferreira**
Faculdade Senac - 2025
