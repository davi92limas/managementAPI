# Management API - Sistema de Gerenciamento de Usuários

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)  
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)  
[![JWT](https://img.shields.io/badge/JWT-Security-red.svg)](https://jwt.io/)  
[![Docker](https://img.shields.io/badge/Docker-Compose-blue.svg)](https://www.docker.com/)  
[![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow.svg)](#-status-do-projeto)  

---

## 📋 Sobre o Projeto  

O **Management API** é uma aplicação back-end em **Spring Boot** para **gerenciamento de usuários e assinaturas**, com autenticação **JWT** e controle de permissões por roles (**USER, MODERATOR, ADMIN**).  

👉 Esse projeto simula o **back-end de um sistema real de assinaturas**, pronto para ser plugado em qualquer front-end (web ou mobile).  

---

## 🎯 Características Principais  

- ✅ Autenticação JWT  
- ✅ Controle de Acesso por Roles  
- ✅ Tratamento Global de Exceções  
- ✅ Validação de Dados (Bean Validation)  
- ✅ Migrações de Banco com Flyway  

---

## 🛠️ Tecnologias Utilizadas  

- **Java 21**  
- **Spring Boot 3.5.5**  
- **Spring Security**  
- **Spring Data JPA**  
- **Spring Web**  
- **Flyway**  
- **Docker & Docker Compose**  
- **MySQL 8.0**  

---

## 🧪 Testes  

O projeto já conta com testes unitários e de integração:  

- **JUnit 5**  
- **Mockito**  
- **Spring Boot Test**  
- **AssertJ**  

👉 Como rodar os testes:  
```bash
./mvnw test
```

---

## 🔐 Sistema de Autenticação e Autorização  

O projeto implementa autenticação **JWT** com **Spring Security**.  

### Matriz de Permissões

| Endpoint                          | 👤 USER | 👨‍💼 MODERATOR | 👑 ADMIN |
|-----------------------------------|---------|-----------------|----------|
| **GET** /users/**                 | ✅       | ✅               | ✅        |
| **POST** /users                   | ❌       | ✅               | ✅        |
| **PUT** /users/**                 | ✅       | ✅               | ✅        |
| **DELETE** /users/**              | ❌       | ❌               | ✅        |
| **GET** /subscription-types/**    | ✅       | ✅               | ✅        |
| **POST** /subscription-types      | ❌       | ✅               | ✅        |
| **PUT** /subscription-types/**    | ❌       | ✅               | ✅        |
| **DELETE** /subscription-types/** | ❌       | ❌               | ✅        |

---

## ⚙️ Instalação e Configuração  

### Pré-requisitos  
- ☕ Java 21+  
- 📦 Maven 3.6+  
- 🐳 Docker & Docker Compose  

### 🚀 Subindo o projeto com 1 comando  
```bash
docker-compose up --build
```

API disponível em:  
- **Base URL:** `http://localhost:8080/api`  
- **Health Check:** `http://localhost:8080/api/auth/health`  

---

## 📡 Exemplos de Uso (Demo)  

### Registro de Usuário
```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "john_doe",
  "email": "john@example.com",
  "password": "123456"
}
```

### Login
```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "john_doe",
  "password": "123456"
}
```

**Resposta:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
}
```

---

## 📁 Estrutura do Projeto  

```
user-management-api/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/com/usermanagement/api/
│   │   │   ├── 📁 config/              # Configurações
│   │   │   ├── 📁 controller/          # Controllers REST
│   │   │   ├── 📁 dto/                 # Data Transfer Objects
│   │   │   ├── 📁 exception/           # Tratamento de Exceções
│   │   │   ├── 📁 model/               # Entidades JPA
│   │   │   ├── 📁 repository/          # Repositories
│   │   │   ├── 📁 security/            # Segurança JWT
│   │   │   ├── 📁 service/             # Serviços de Negócio
│   │   │   ├── 📁 util/                # Utilitários
│   │   │   └── UserManagementApplication.java # Classe Principal
│   │   └── 📁 resources/
│   │       ├── 📁 db/migration/        # Migrações Flyway
│   │       ├── 📁 static/              # Recursos Estáticos
│   │       └── application.properties   # Configurações
│   └── 📁 test/                        # Testes
│       ├── 📁 java/com/client/rasmoo/davi/
│       └── 📁 resources/
├── 📁 docker/                          # Docker Configuration
├── docker-compose.yml                  # Docker Compose
├── pom.xml                            # Maven Dependencies
├── Rasmoo_CRUD_APIs.postman_collection.json
└── README.md                          # Este arquivo
```

---

## 🛣️ Roadmap  

- [ ] Documentação com Swagger/OpenAPI  
- [ ] Integração contínua (GitHub Actions)  
- [ ] Testes de cobertura com Jacoco/Sonar  
- [ ] Cache com Redis  
- [ ] Deploy em nuvem (Heroku/AWS)  
