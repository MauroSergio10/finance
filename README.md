# <center> 💰 Controle Financeiro Pessoal </center>



## Introdução
Aplicação com objetivo de fornecer controle financeiro que registra 
receitas e despesas mensais, calcula o saldo disponível e apresenta a 
distribuição percentual dos gastos por categoria.


## Objetivo
Este sistema tem como objetivo permitir o controle de receitas e despesas de forma
centralizada, automatizada e confiável, substituindo o uso de planilhas manuais.

A aplicação busca reduzir operações repetitivas, minimizar erros no registro de dados
e facilitar a visualização do histórico financeiro, servindo como base para análises
e futuras evoluções do sistema.

## Tecnologias utilizadas

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-3.9-orange?style=for-the-badge&logo=apachemaven)


## Arquitetura
O projeto utiliza uma **arquitetura em camadas**, adequada para aplicações REST, separando responsabilidades para facilitar manutenção, testes e evolução do sistema.

- **Controller**: Responsável por expor os endpoints REST e receber as requisições
- **Service**: Contém as regras de negócio da aplicação
- **Repository**: Responsável pelo acesso e persistência dos dados
- **Entity**: Representação das entidades e tabelas do banco de dados

## Status do Projeto
Em desenvolvimento

Funcionalidades estão sendo implementadas de forma incremental.

## Como Executar o Projeto

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

<p align="right">
  <a href="https://github.com/MauroSergio10/finance?tab=readme-ov-file#--controle-financeiro-pessoal-">Voltar para o topo</a>
</p>



