# 💰 Financial Control API

API REST para **gerenciamento de finanças pessoais**, permitindo registrar receitas, despesas e categorizar transações para melhor controle financeiro.

Este projeto foi desenvolvido com foco em **boas práticas de arquitetura backend**, organização de domínio e separação de responsabilidades.

---

# 📌 Objetivo do Projeto

O objetivo do sistema é permitir que usuários registrem e organizem suas movimentações financeiras, possibilitando:

- controle de receitas e despesas
- categorização de transações
- visualização organizada dos gastos

Este projeto também tem como objetivo **demonstrar conhecimentos em desenvolvimento backend com Java e arquitetura limpa**.

---

# 🏗️ Arquitetura

O projeto segue princípios de **Clean Architecture**, separando responsabilidades em camadas independentes.

Estrutura principal:


| POST | /categories | Criar categoria |
| GET | /categories | Listar categorias |
| DELETE | /categories/{id} | Remover categoria |

---

# 🧪 Testes

O projeto inclui **testes unitários** para validar:

- regras de negócio
- casos de uso
- comportamento da aplicação

Ferramentas utilizadas:

- JUnit
- Mockito

---

# 🚀 Como Executar o Projeto


### Camadas

#### Domain
Responsável pelo **núcleo do sistema**.

Contém:

- entidades do domínio
- regras de negócio
- interfaces de repositório

Essa camada **não depende de nenhuma outra**.

---

#### Application
Contém os **casos de uso da aplicação**.

Responsável por:

- orquestrar regras de negócio
- executar ações do sistema

Exemplos:

- CreateTransactionUseCase
- ListTransactionsUseCase
- CreateCategoryUseCase

---

#### Infrastructure
Responsável pela **implementação técnica**.

Contém:

- persistência no banco de dados
- implementações dos repositórios
- integração com frameworks

Exemplo:

- JPA repositories
- configurações de banco

---

#### Interface
Camada responsável pela **comunicação com o mundo externo**.

Contém:

**Controllers**

Responsáveis por:

- receber requisições HTTP
- chamar os casos de uso

**Mappers**

Responsáveis por:

- converter **DTO → Model**
- converter **Model → DTO**

Isso mantém o **domínio isolado da camada de transporte da API**.

---

# ⚙️ Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Maven
- PostgreSQL / H2
- JUnit
- REST API

---

# 📊 Modelo de Domínio

## Transaction

Representa uma movimentação financeira.

Campos principais:

- id
- description
- amount
- type
- date
- categoryId
- categoryName
- bankAccountId

---

## Category

Representa a categoria de uma transação.

Campos principais:

- id
- name

---

## BankAccount

Representa uma conta bancária.

Campos principais:

- id
- name
- balance
- description
- userId

---

# 📋 Requisitos Funcionais

O sistema deve permitir:

- Criar transações financeiras
- Editar transações
- Remover transações
- Listar transações
- Criar categorias
- Listar categorias
- Associar categorias às transações
- Criar contas bancárias
- Listar contas bancárias
- Editar contas bancárias
- Remover contas bancárias
- Associar transações a contas bancárias

---

# 📏 Regras de Negócio

- O valor da transação deve ser **maior que zero**
- Toda transação deve possuir **uma categoria válida**
- A data da transação **não pode ser futura**


---

# 🔌 Endpoints da API

## Transactions

| Método | Endpoint | Descrição |
|------|------|------|
| POST | /transactions | Criar transação |
| GET | /transactions | Listar transações |
| GET | /transactions/{id} | Buscar transação |
| PUT | /transactions/{id} | Atualizar transação |
| DELETE | /transactions/{id} | Remover transação |

---

## Categories

| Método | Endpoint | Descrição |
|------|------|------|
| POST | /categories | Criar categoria |
| GET | /categories | Listar categorias |
| DELETE | /categories/{id} | Remover categoria |

---

## BankAccounts

| Método | Endpoint | Descrição |
|------|------|------|
| POST | /bankaccounts | Criar conta bancária |
| GET | /bankaccounts | Listar contas bancárias |
| GET | /bankaccounts/{id} | Buscar conta bancária |
| PUT | /bankaccounts/{id} | Atualizar conta bancária |
| DELETE | /bankaccounts/{id} | Remover conta bancária |

---

# 🧪 Testes

O projeto inclui **testes unitários** para validar:

- regras de negócio
- casos de uso
- comportamento da aplicação

Ferramentas utilizadas:

- JUnit
- Mockito

---

# 🚀 Como Executar o Projeto

### Clonar o repositório

```bash
git clone https://github.com/seuusuario/financial-control-api.git