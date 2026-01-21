# <center> 💰 Personal financial control </center>



## Introduction
An application designed to improve financial management that allows users to 
record income and expenses, track balances, and analyse spending by category in an
automated and centralized way.

## Tecnology

![Java](https://img.shields.io/badge/Java-21-red?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2-brightgreen?style=for-the-badge&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=for-the-badge&logo=postgresql)
![Maven](https://img.shields.io/badge/Maven-3.9-orange?style=for-the-badge&logo=apachemaven)


## Architecture
O projeto utiliza uma **arquitetura em camadas**, adequada para aplicações REST, separando
responsabilidades para facilitar manutenção, testes e evolução do sistema.

The project uses a "layered architecture", suitable to a Rest applications, by 
separating responsibilities to make maintenance, testing and future improvements easier.

- **Controller**: Responsible for exposing REST endpoints and receiving requests.
- **Service**: Contains the application´s business rules.
- **Repository**: Handles data access and persistence
- **Entity**: Represents database table


## Project status
Under development

## Tutorial

### Represents database table
- Java 21 
- Maven

### Running the project
This project is designed to run out of the box without requiring any external services.

By default, it runs with:

- H2 in-memory database
- Mocked authentication
- No Supabase configuration required

Supabase (PostgreSQL + Auth) is used only in the proction profile

1. Clone the repository:
```bash
git clone https://github.com/MauroSergio10/finance.git
cd finance
```

2. Instalar as dependências
```bash
mvn clean install
```

3. Execultar o projeto
```bash
mvn spring-boot:run
````

The application will start using:
- H2 database
- Mocked authentication

4. A aplicação estará disponivel em:
   http://localhost:8080

5. Run with Supabase (production profile)

To run the project using Supabase (PostgreSQL + JWT authentication), activate the prod profile and configure the required environment variables.

3.1 Set environment variables

```
export SPRING_PROFILES_ACTIVE=prod
export SUPABASE_ISSUER_URI=https://<PROJECT_ID>.supabase.co/auth/v1

export SPRING_DATASOURCE_URL=jdbc:postgresql://<host>:<port>/<database>
export SPRING_DATASOURCE_USERNAME=<username>
export SPRING_DATASOURCE_PASSWORD=<password>
```

Supabase credentials and secrets are not versioned for security reasons.


<p align="right">
  <a href="https://github.com/MauroSergio10/finance?tab=readme-ov-file#--controle-financeiro-pessoal-">Voltar para o topo</a>
</p>



