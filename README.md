# 💰 Controle Financeiro Pessoal

## 📌 Visão Geral
Aplicação com objetivo de fornecer controle financeiro que registra 
receitas e despesas mensais, calcula o saldo disponível e apresenta a 
distribuição percentual dos gastos por categoria.

---

## 🎯 Objetivo
Controle financeiro de forma clara, simples e dinâmica

---

## ⚙️ Tecnologias utilizadas
- **Java 21**
- **Spring Boot**
- **JPA / Hibernate**
- **Supabase**
- **Maven**

---

## 🧱 Arquitetura
O projeto utiliza uma **arquitetura em camadas**, adequada para aplicações REST, separando responsabilidades para facilitar manutenção, testes e evolução do sistema.

- **Controller**: Responsável por expor os endpoints REST e receber as requisições
- **Service**: Contém as regras de negócio da aplicação
- **Repository**: Responsável pelo acesso e persistência dos dados
- **Entity**: Representação das entidades e tabelas do banco de dados

---

## 🚀 Status do Projeto
Em desenvolvimento

Funcionalidades estão sendo implementadas de forma incremental.

---

## ▶️ Como Executar o Projeto

### Pré-requisitos
- Java 21 instalado
- Maven
- Conta no Supabase (PosgresSQL)

### Execução do projeto

Este projeto utiliza Supabase como backend (PostgreSQL).

Por motivos de segurança:
- As credenciais do Supabase **não estão versionadas**
- Não há ambiente público de demonstração

A execução local requer a configuração manual das variáveis de ambiente.

1. Clone o repositório:
```bash
git clone https://github.com/MauroSergio10/finance.git
```
2. Configuração das variáveis de ambiente
   A aplicação utiliza **PostgreSQL** como banco de dados.

As configurações de conexão devem ser definidas no arquivo `application.properties` ou por meio de variáveis de ambiente.

Exemplo de configuração:

```properties
spring.datasource.url=jdbc:postgresql://<host>:<porta>/<database>
spring.datasource.username=<usuario>
spring.datasource.password=<senha>

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
````

3. Instalar as dependências
```bash
mvn clean install
```

3. Execultar o projeto
```bash
mvn spring-boot:run
````
4. A aplicação estará disponivel em:
   http://localhost:8080

