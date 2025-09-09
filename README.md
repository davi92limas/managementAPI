# 🚀 User Management API - Sistema Completo de Gerenciamento de Usuários

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)](https://www.mysql.com/)
[![JWT](https://img.shields.io/badge/JWT-Security-red.svg)](https://jwt.io/)
[![Docker](https://img.shields.io/badge/Docker-Compose-blue.svg)](https://www.docker.com/)
[![Status](https://img.shields.io/badge/Status-Production%20Ready-green.svg)](#-status-do-projeto)

## 📋 Sobre o Projeto

O **User Management API** é uma aplicação back-end robusta e genérica desenvolvida em **Spring Boot** que implementa um sistema completo de gerenciamento de usuários com autenticação JWT e controle de acesso baseado em roles. O projeto foi projetado para ser **reutilizável** e pode ser facilmente adaptado para diferentes tipos de aplicações que necessitam de um sistema de usuários seguro e escalável.

### 🎯 Características Principais

Esta API genérica de gerenciamento de usuários oferece:

- ✅ **Sistema de Autenticação JWT** completo e seguro
- ✅ **Controle de Acesso Baseado em Roles** (USER, MODERATOR, ADMIN)
- ✅ **Tratamento Global de Exceções** com respostas padronizadas
- ✅ **Validação de Dados** robusta com Bean Validation
- ✅ **Arquitetura em Camadas** bem estruturada
- ✅ **Containerização** com Docker e Docker Compose
- ✅ **Migrações de Banco** automatizadas com Flyway
- ✅ **Utilitários de Segurança** (gerador de senhas, validação)
- ✅ **Pronto para Produção** com configurações otimizadas

## 🏗️ Arquitetura do Sistema

### 📐 Padrão Arquitetural

O projeto segue uma **arquitetura em camadas (Layered Architecture)** bem definida:

```
┌─────────────────────────────────────────────────────────────┐
│                    PRESENTATION LAYER                       │
│  Controllers REST + DTOs + Exception Handlers + Security   │
├─────────────────────────────────────────────────────────────┤
│                     BUSINESS LAYER                         │
│     Services + Business Logic + Validation + Auth          │
├─────────────────────────────────────────────────────────────┤
│                   PERSISTENCE LAYER                        │
│        Repositories + JPA Entities + Database              │
├─────────────────────────────────────────────────────────────┤
│                   INFRASTRUCTURE LAYER                     │
│    Configuration + Security + JWT + Flyway + Docker        │
└─────────────────────────────────────────────────────────────┘
```

## 🛠️ Tecnologias Utilizadas

### **Backend Core**
- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.5** - Framework principal
- **Spring Data JPA** - Persistência de dados
- **Spring Security** - Autenticação e autorização
- **Spring Web** - APIs REST
- **Spring Validation** - Validação de dados

### **Segurança**
- **JWT (JSON Web Tokens)** - Autenticação stateless
- **BCrypt** - Criptografia de senhas
- **CORS** - Controle de acesso cross-origin
- **Role-based Authorization** - Autorização baseada em roles

### **Banco de Dados**
- **MySQL 8.0** - Banco de dados relacional
- **Flyway** - Migrações e versionamento
- **H2 Database** - Banco em memória para testes
- **HikariCP** - Pool de conexões

### **Testes**
- **JUnit 5** - Framework de testes
- **Mockito** - Mocking para testes unitários
- **Spring Boot Test** - Testes de integração
- **AssertJ** - Assertions fluentes

### **Documentação**
- **SpringDoc OpenAPI 3** - Documentação automática
- **Swagger UI** - Interface interativa da API
- **Postman Collection** - Coleção de testes

### **DevOps e Ferramentas**
- **Docker & Docker Compose** - Containerização
- **Maven** - Gerenciamento de dependências
- **Lombok** - Redução de boilerplate
- **Jackson** - Serialização JSON

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

## 🔐 Sistema de Autenticação e Autorização

### **Arquitetura de Segurança**

O projeto implementa um sistema completo de autenticação **JWT (JSON Web Tokens)** com **Spring Security**:

#### **🛡️ Matriz de Permissões**

| Endpoint | 👤 USER | 👨‍💼 MODERATOR | 👑 ADMIN |
|----------|---------|---------------|----------|
| **GET** /users/** | ✅ | ✅ | ✅ |
| **POST** /users | ❌ | ✅ | ✅ |
| **PUT** /users/** | ✅ | ✅ | ✅ |
| **DELETE** /users/** | ❌ | ❌ | ✅ |
| **GET** /subscription-types/** | ✅ | ✅ | ✅ |
| **POST** /subscription-types | ❌ | ✅ | ✅ |
| **PUT** /subscription-types/** | ❌ | ✅ | ✅ |
| **DELETE** /subscription-types/** | ❌ | ❌ | ✅ |

### **👥 Usuários Padrão**

| Username | Email | Role | Senha |
|----------|-------|------|-------|
| `admin` | admin@usermanagement.com | ADMIN | `password` |
| `moderator` | moderator@usermanagement.com | MODERATOR | `password` |
| `user` | user@usermanagement.com | USER | `password` |

## ⚙️ Configuração e Instalação

### **📋 Pré-requisitos**

- ☕ **Java 21+**
- 📦 **Maven 3.6+**
- 🐳 **Docker & Docker Compose**
- 🗄️ **MySQL 8.0** (via Docker)

### **🚀 Instalação**

#### **1. Clone o Repositório**
```bash
git clone https://github.com/seu-usuario/user-management-api.git
cd user-management-api
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

## 🔑 Autenticação JWT

### **🚪 Endpoints de Autenticação**

| Método | Endpoint | Descrição | Acesso |
|--------|----------|-----------|--------|
| `POST` | `/auth/register` | Registrar novo usuário | 🌐 Público |
| `POST` | `/auth/login` | Fazer login | 🌐 Público |
| `POST` | `/auth/refresh` | Renovar token | 🔒 Autenticado |
| `GET` | `/auth/validate` | Validar token | 🔒 Autenticado |
| `GET` | `/auth/health` | Status do serviço | 🌐 Público |

### **📝 Exemplos de Uso**

#### **1. Registrar Usuário**
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "username": "novousuario",
    "email": "novo@usermanagement.com",
    "password": "minhasenha123"
  }'
```

#### **2. Fazer Login**
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "usernameOrEmail": "admin",
    "password": "password"
  }'
```

**Resposta:**
```json
{
  "accessToken": "eyJhbGciOiJIUzI1NiJ9...",
  "refreshToken": "eyJhbGciOiJIUzI1NiJ9...",
  "tokenType": "Bearer",
  "expiresIn": 86400,
  "userInfo": {
    "username": "admin",
    "email": "admin@usermanagement.com",
    "role": "ADMIN"
  }
}
```

#### **3. Acessar Endpoint Protegido**
```bash
curl -X GET http://localhost:8080/api/users \
  -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9..."
```

## 🛡️ Endpoints da API

### **🔓 Endpoints Públicos**
- `POST /auth/register` - Registro de usuários
- `POST /auth/login` - Login
- `GET /auth/health` - Health check de autenticação

### **🔒 Endpoints Protegidos**

#### **👥 Usuários (`/users`)**
| Método | Endpoint | Permissões | Descrição |
|--------|----------|------------|-----------|
| `GET` | `/users` | USER, MODERATOR, ADMIN | Lista usuários |
| `GET` | `/users/{id}` | USER, MODERATOR, ADMIN | Busca por ID |
| `GET` | `/users/email/{email}` | USER, MODERATOR, ADMIN | Busca por email |
| `GET` | `/users/phone/{phone}` | USER, MODERATOR, ADMIN | Busca por telefone |
| `POST` | `/users` | MODERATOR, ADMIN | Criar usuário |
| `PUT` | `/users/{id}` | USER, MODERATOR, ADMIN | Atualizar usuário |
| `DELETE` | `/users/{id}` | ADMIN | Deletar usuário |

#### **📋 Tipos de Assinatura (`/subscription-types`)**
| Método | Endpoint | Permissões | Descrição |
|--------|----------|------------|-----------|
| `GET` | `/subscription-types` | USER, MODERATOR, ADMIN | Lista tipos |
| `GET` | `/subscription-types/{id}` | USER, MODERATOR, ADMIN | Busca por ID |
| `GET` | `/subscription-types/product-key/{key}` | USER, MODERATOR, ADMIN | Busca por chave |
| `POST` | `/subscription-types` | MODERATOR, ADMIN | Criar tipo |
| `PUT` | `/subscription-types/{id}` | MODERATOR, ADMIN | Atualizar tipo |
| `DELETE` | `/subscription-types/{id}` | ADMIN | Deletar tipo |

## 🧪 Testes e Validação

### **✅ Testes Realizados**

```bash
# Compilar e testar a aplicação
./mvnw clean compile
./mvnw spring-boot:run
```

### **🔬 Validações Implementadas**

#### **Endpoints Testados**
- ✅ **Health Check** - `/auth/health`
- ✅ **Registro de Usuários** - `/auth/register`
- ✅ **Login** - `/auth/login`
- ✅ **Autenticação JWT** - Tokens funcionando
- ✅ **Autorização** - Controle de acesso por roles

#### **Funcionalidades Validadas**
- ✅ **Banco de Dados** - Conexão e migrações Flyway
- ✅ **Segurança** - JWT e Spring Security
- ✅ **API** - Endpoints REST funcionais
- ✅ **Exceções** - Tratamento global implementado

## 🐳 Containerização

### **Docker Compose**

```yaml
# docker-compose.yml
services:
  mysql:
    image: mysql:8.0
    container_name: user-management-mysql
    command: --default-authentication-plugin=mysql_native_password
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: USER_MANAGEMENT
      MYSQL_USER: admin
      MYSQL_PASSWORD: admin123
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

### **🚀 Deploy com Docker**

```bash
# Build da aplicação
./mvnw clean package -DskipTests

# Build da imagem Docker
docker build -t user-management-api .

# Executar com Docker Compose
docker-compose up -d
```

## ⚙️ Configurações

### **🔧 Variáveis de Ambiente**

| Variável | Padrão | Descrição |
|----------|--------|-----------|
| `SERVER_PORT` | `8080` | Porta da aplicação |
| `DB_HOST` | `localhost` | Host do MySQL |
| `DB_PORT` | `3306` | Porta do MySQL |
| `DB_NAME` | `USER_MANAGEMENT` | Nome do banco |
| `DB_USER` | `admin` | Usuário do banco |
| `DB_PASSWORD` | `admin123` | Senha do banco |
| `JWT_SECRET` | `user-management-secret-key-2024-super-secure-jwt-token` | Chave JWT |
| `JWT_EXPIRATION` | `86400000` | Expiração do token (24h) |
| `JWT_REFRESH_EXPIRATION` | `604800000` | Expiração do refresh (7d) |

### **📝 application.properties**

```properties
# Application Configuration
spring.application.name=user-management-api

# Server Configuration
server.port=8080
server.servlet.context-path=/api

# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/USER_MANAGEMENT
spring.datasource.username=admin
spring.datasource.password=admin123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA Configuration
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=false
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# Flyway Configuration
spring.flyway.enabled=true
spring.flyway.validate-on-migrate=false

# JWT Configuration
jwt.secret=user-management-secret-key-2024-super-secure-jwt-token
jwt.expiration=86400000
jwt.refresh-expiration=604800000
```

## 🚀 Deploy em Produção

### **☁️ Preparação para Deploy**

#### **1. Configurações de Produção**
```properties
# application-prod.properties
spring.profiles.active=prod
spring.jpa.show-sql=false
logging.level.com.usermanagement.api=INFO
jwt.secret=${JWT_SECRET}
spring.datasource.url=${DATABASE_URL}
```

#### **2. Dockerfile**
```dockerfile
FROM openjdk:21-jdk-slim
VOLUME /tmp
COPY target/user-management-api-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

#### **3. Health Checks**
```bash
# Verificar saúde da aplicação
curl http://localhost:8080/api/auth/health

# Verificar métricas (se Actuator estiver habilitado)
curl http://localhost:8080/api/actuator/health
```

## 🔍 Monitoramento e Logs

### **📊 Métricas**
- **Health Checks** - Status da aplicação
- **Database Connection** - Conectividade com MySQL
- **JWT Validation** - Validação de tokens
- **API Response Times** - Performance dos endpoints

### **📝 Logs Estruturados**
```bash
# Visualizar logs em tempo real
docker-compose logs -f

# Logs específicos da aplicação
tail -f logs/application.log
```

## 🤝 Contribuição

### **🔄 Workflow de Desenvolvimento**

1. **Fork** o repositório
2. **Clone** seu fork localmente
3. **Crie** uma branch para sua feature
4. **Desenvolva** e teste suas mudanças
5. **Commit** seguindo convenções
6. **Push** para seu fork
7. **Abra** um Pull Request

### **📋 Convenções**

#### **Commits**
```bash
feat: adiciona endpoint de busca por CPF
fix: corrige validação de email duplicado
docs: atualiza documentação da API
test: adiciona testes para AuthService
```

#### **Branches**
- `main` - Produção
- `develop` - Desenvolvimento
- `feature/nome-da-feature` - Novas funcionalidades
- `fix/nome-do-bug` - Correções
- `docs/nome-da-doc` - Documentação

## 📚 Recursos Adicionais

### **📖 Documentação Técnica**
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/)
- [Spring Security JWT](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)
- [MySQL 8.0 Documentation](https://dev.mysql.com/doc/refman/8.0/en/)
- [Flyway Documentation](https://flywaydb.org/documentation/)

### **🛠️ Ferramentas Recomendadas**
- **IDE:** IntelliJ IDEA ou VS Code
- **API Testing:** Postman ou Insomnia
- **Database:** MySQL Workbench
- **Containers:** Docker Desktop

## 📞 Suporte e Contato

### **🆘 Obtendo Ajuda**
- **Issues:** [GitHub Issues](https://github.com/seu-usuario/user-management-api/issues)
- **Discussions:** [GitHub Discussions](https://github.com/seu-usuario/user-management-api/discussions)
- **Email:** contato@usermanagement.com

### **📋 Checklist de Problemas**
- [ ] MySQL está rodando?
- [ ] Variáveis de ambiente configuradas?
- [ ] Migrações Flyway executadas?
- [ ] Token JWT válido?
- [ ] Permissões de role corretas?

---

## 📄 Licença

Este projeto está licenciado sob a **MIT License** - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

## 🏆 Status do Projeto

**✅ Funcionalidades Implementadas:**
- [x] Sistema completo de autenticação JWT
- [x] Autorização baseada em roles (USER, MODERATOR, ADMIN)
- [x] CRUD completo de usuários e tipos de assinatura
- [x] Validação de dados com Bean Validation
- [x] Tratamento global de exceções
- [x] Testes automatizados (unitários e integração)
- [x] Documentação completa da API
- [x] Containerização com Docker
- [x] Migrações de banco com Flyway
- [x] Health checks e monitoramento

**🔄 Próximas Funcionalidades:**
- [ ] Rate limiting para APIs
- [ ] Cache com Redis
- [ ] Logs estruturados com ELK Stack
- [ ] Métricas com Prometheus
- [ ] API versioning
- [ ] Refresh token rotation
- [ ] Password reset via email
- [ ] Two-factor authentication (2FA)

---

**📊 Estatísticas do Projeto:**
- **Linhas de Código:** ~2,800
- **Arquitetura:** Camadas bem definidas
- **Segurança:** JWT + Spring Security
- **Endpoints:** 12+ endpoints funcionais
- **Última Atualização:** Janeiro 2025

**🚀 Ready for Production!** ✨
