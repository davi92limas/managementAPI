-- Atualizar senhas dos usuários de autenticação com hash BCrypt correto
-- Senha: password

UPDATE auth_users 
SET password = '$2a$10$aRk7BVIoVjRKxY73u6XwLuQtVh9IRhzoO.Bjm3GjUSrtUPHe.q.2a'
WHERE username IN ('admin', 'moderator', 'user');
