-- Criação da tabela de usuários para autenticação
CREATE TABLE auth_users (
    auth_user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('USER', 'ADMIN', 'MODERATOR') NOT NULL DEFAULT 'USER',
    account_non_expired BOOLEAN NOT NULL DEFAULT TRUE,
    account_non_locked BOOLEAN NOT NULL DEFAULT TRUE,
    credentials_non_expired BOOLEAN NOT NULL DEFAULT TRUE,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    INDEX idx_auth_users_username (username),
    INDEX idx_auth_users_email (email),
    INDEX idx_auth_users_role (role),
    INDEX idx_auth_users_enabled (enabled)
);

-- Insert default admin user
INSERT INTO auth_users (username, email, password, role, enabled) 
VALUES (
    'admin', 
    'admin@usermanagement.com', 
    '$2a$10$aRk7BVIoVjRKxY73u6XwLuQtVh9IRhzoO.Bjm3GjUSrtUPHe.q.2a', -- password
    'ADMIN', 
    TRUE
);

-- Insert moderator user for testing
INSERT INTO auth_users (username, email, password, role, enabled) 
VALUES (
    'moderator', 
    'moderator@usermanagement.com', 
    '$2a$10$aRk7BVIoVjRKxY73u6XwLuQtVh9IRhzoO.Bjm3GjUSrtUPHe.q.2a', -- password
    'MODERATOR', 
    TRUE
);

-- Insert regular user for testing
INSERT INTO auth_users (username, email, password, role, enabled) 
VALUES (
    'user', 
    'user@usermanagement.com', 
    '$2a$10$aRk7BVIoVjRKxY73u6XwLuQtVh9IRhzoO.Bjm3GjUSrtUPHe.q.2a', -- password
    'USER', 
    TRUE
);
