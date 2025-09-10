# Management API - Sistema de Gerenciamento de Usuários

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![JWT](https://img.shields.io/badge/JWT-Security-red.svg)](https://jwt.io/)
[![Docker](https://img.shields.io/badge/Docker-Compose-blue.svg)](https://www.docker.com/)
[![Status](https://img.shields.io/badge/Status-Production%20Ready-green.svg)](#-status-do-projeto)

## 📋 Sobre o Projeto

O **Management API** é uma aplicação back-end, desenvolvida em **Spring Boot** que implementa um
sistema de gerenciamento de usuários com autenticação JWT e controle de acesso baseado em roles(USER, MODERATOR, ADMIN). O projeto foi
projetado para ser **reutilizável** e pode ser facilmente adaptado para diferentes tipos de aplicações que necessitam de
um sistema de usuários.

## 🎯 Características Principais

- ✅ **Sistema de Autenticação JWT**
- ✅ **Controle de Acesso**
- ✅ **Tratamento Global de Exceções**
- ✅ **Validação de Dados** 
- ✅ **Migrações de Banco** 

## 🛠️ Tecnologias Utilizadas

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.5** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Security** - Autenticação e autorização
- **Spring Web** - APIs REST
- **Validação de Dados** Com Bean Validation
- **Migrações de Banco** Com Flyway

## **🧪 Testes**

- **JUnit 5** - Framework de testes
- **Mockito** - Mocking para testes unitários
- **Spring Boot Test** - Testes de integração
- **AssertJ** - Assertions fluentes


## 🔐 Sistema de Autenticação e Autorização

O projeto implementa um sistema completo de autenticação **JWT (JSON Web Tokens)** com **Spring Security**:

#### **🛡️ Matriz de Permissões**

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

## ⚙️ Configuração e Instalação

- ☕ **Java 21+**
- 📦 **Maven 3.6+**
- 🐳 **Docker & Docker Compose**
- 🗄️ **MySQL 8.0** (via Docker)

### **🚀 Instalação**

#### **1. Clone o Repositório**

```bash
git clone https://github.com/davi92limas/managementAPI.git
cd managementAPI
```

#### **2. Configure o Banco de Dados**

```bash
# Inicie o MySQL
docker-compose up -d

# Verifique se está rodando
docker-compose ps
```

#### **3. Execute a Aplicação**

```bash
# Compile e execute
./mvnw spring-boot:run

# Ou compile e execute separadamente
./mvnw clean compile
./mvnw spring-boot:run
```

#### **4. Acesse a Aplicação**

- **API Base:** `http://localhost:8080/api`
- **Health Check:** `http://localhost:8080/api/auth/health`
- **Documentação:** Em desenvolvimento

## 🔑 Autenticação JWT - Endpoints de Autenticação


| Método | Endpoint         | Descrição              | Acesso         |
|--------|------------------|------------------------|----------------|
| `POST` | `/auth/register` | Registrar novo usuário | 🌐 Público     |
| `POST` | `/auth/login`    | Fazer login            | 🌐 Público     |
| `POST` | `/auth/refresh`  | Renovar token          | 🔒 Autenticado |
| `GET`  | `/auth/validate` | Validar token          | 🔒 Autenticado |
| `GET`  | `/auth/health`   | Status do serviço      | 🌐 Público     |



## 📁 Estrutura do Projeto

```
user-management-api/
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/com/usermanagement/api/
│   │   │   ├── 📁 config/              # Configurações
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── 📁 controller/          # Controllers REST
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── SubscriptionTypeController.java
│   │   │   │   └── UserController.java
│   │   │   ├── 📁 dto/                 # Data Transfer Objects
│   │   │   │   ├── 📁 request/
│   │   │   │   │   ├── LoginRequest.java
│   │   │   │   │   └── RegisterRequest.java
│   │   │   │   └── 📁 response/
│   │   │   │       └── AuthResponse.java
│   │   │   ├── 📁 exception/           # Tratamento de Exceções
│   │   │   │   ├── DuplicateResourceException.java
│   │   │   │   ├── ErrorResponse.java
│   │   │   │   ├── GlobalExceptionHandler.java
│   │   │   │   └── ResourceNotFoundException.java
│   │   │   ├── 📁 model/               # Entidades JPA
│   │   │   │   ├── AuthUser.java
│   │   │   │   ├── SubscriptionType.java
│   │   │   │   ├── User.java
│   │   │   │   └── UserType.java
│   │   │   ├── 📁 repository/          # Repositories
│   │   │   │   ├── AuthUserRepository.java
│   │   │   │   ├── SubscriptionTypeRepository.java
│   │   │   │   ├── UserRepository.java
│   │   │   │   └── UserTypeRepository.java
│   │   │   ├── 📁 security/            # Segurança JWT
│   │   │   │   ├── CustomUserDetailsService.java
│   │   │   │   ├── JwtAuthenticationFilter.java
│   │   │   │   └── JwtUtil.java
│   │   │   ├── 📁 service/             # Serviços de Negócio
│   │   │   │   ├── AuthService.java
│   │   │   │   ├── SubscriptionTypeService.java
│   │   │   │   └── UserService.java
│   │   │   ├── 📁 util/                # Utilitários
│   │   │   │   └── PasswordGenerator.java
│   │   │   └── UserManagementApplication.java # Classe Principal
│   │   └── 📁 resources/
│   │       ├── 📁 db/migration/        # Migrações Flyway
│   │       │   ├── V1__Create_user_type_table.sql
│   │       │   ├── V2__Create_subscription_type_table.sql
│   │       │   ├── V3__Create_user_table.sql
│   │       │   ├── V4__Create_auth_users_table.sql
│   │       │   └── V5__Update_auth_users_passwords.sql
│   │       ├── 📁 static/              # Recursos Estáticos
│   │       │   └── api-docs.html
│   │       └── application.properties   # Configurações
│   └── 📁 test/                        # Testes
│       ├── 📁 java/com/client/rasmoo/davi/
│       │   ├── 📁 controller/          # Testes de Controllers
│       │   ├── 📁 repository/          # Testes de Repositories
│       │   ├── 📁 service/             # Testes de Services
│       │   └── ApplicationIntegrationTest.java
│       └── 📁 resources/
│           └── application-test.properties
├── 📁 docker/                          # Docker Configuration
├── docker-compose.yml                  # Docker Compose
├── pom.xml                            # Maven Dependencies
├── Rasmoo_CRUD_APIs.postman_collection.json
└── README.md                          # Este arquivo
```


