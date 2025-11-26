-- 1. Criação do Banco de Dados
CREATE DATABASE IF NOT EXISTS salvacarteira;
USE salvacarteira;

-- 2. Criação da Tabela de Categorias
CREATE TABLE IF NOT EXISTS categoria (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao VARCHAR(255)
);

-- 3. Criação da Tabela de Transações
CREATE TABLE IF NOT EXISTS transacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    valor DECIMAL(19, 2) NOT NULL,
    data DATE NOT NULL,
    tipo VARCHAR(50) NOT NULL, -- Valores esperados: 'RECEITA' ou 'DESPESA'
    categoria_id BIGINT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

-- 4. Inserção de Dados Iniciais (Opcional - Para testar na apresentação)
-- Categorias
INSERT INTO categoria (nome, descricao) VALUES 
('Alimentação', 'Mercado, restaurantes e lanches'),
('Transporte', 'Uber, combustível e ônibus'),
('Salário', 'Fontes de renda mensal'),
('Lazer', 'Cinema, streaming e jogos');

-- Transações (Exemplos)
-- Receita: Salário
INSERT INTO transacao (descricao, valor, data, tipo, categoria_id) VALUES 
('Salário Mensal', 3500.00, CURDATE(), 'RECEITA', 3);

-- Despesa: Mercado
INSERT INTO transacao (descricao, valor, data, tipo, categoria_id) VALUES 
('Compras da Semana', 450.50, CURDATE(), 'DESPESA', 1);

-- Despesa: Uber
INSERT INTO transacao (descricao, valor, data, tipo, categoria_id) VALUES 
('Uber para o trabalho', 25.90, CURDATE(), 'DESPESA', 2);
