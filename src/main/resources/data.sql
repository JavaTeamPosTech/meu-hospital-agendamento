-- CREATE TABLE IF NOT EXISTS usuarios
-- (
--     id              UUID PRIMARY KEY DEFAULT gen_random_uuid(),
--     nome            VARCHAR(100)        NOT NULL,
--     telefone        VARCHAR(15),
--     email           VARCHAR(100) UNIQUE NOT NULL,
--     data_nascimento DATE,
--     cpf             VARCHAR(11) UNIQUE  NOT NULL,
--     login           VARCHAR(11) UNIQUE  NOT NULL,
--     senha           VARCHAR(11)       NOT NULL
--     );


-- CREATE TABLE IF NOT EXISTS enfermeiros
-- (
--     id               UUID PRIMARY KEY,
--     usuario_id       UUID REFERENCES usuarios (id) ON DELETE CASCADE,
--     especialidade    VARCHAR(100),
--     salario_por_hora DECIMAL(10, 2),
--     coren            VARCHAR(15) UNIQUE
--     );

-- CREATE TABLE IF NOT EXISTS pacientes
-- (
--     id                  UUID PRIMARY KEY,
--     usuario_id          UUID REFERENCES usuarios (id) ON DELETE CASCADE,
--     convenio            VARCHAR(100),
--     status              VARCHAR(20),
--     numero_cartao_saude VARCHAR(30)
--     );

CREATE TABLE IF NOT EXISTS hospitais
(
    id                UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    endereco          VARCHAR(255) NOT NULL,
    convenios_aceitos VARCHAR(255)
    );

-- CREATE TABLE IF NOT EXISTS especialidades
-- (
--     id   UUID PRIMARY KEY DEFAULT gen_random_uuid(),
--     nome VARCHAR(100) NOT NULL
--     );
--
-- CREATE TABLE IF NOT EXISTS medicos
-- (
--     id               UUID PRIMARY KEY,
--     usuario_id       UUID REFERENCES usuarios (id) ON DELETE CASCADE,
--     especialidade_id UUID REFERENCES especialidades (id),
--     salario_por_hora DECIMAL(10, 2),
--     crm              VARCHAR(15) UNIQUE
--     );

CREATE TABLE IF NOT EXISTS consultas_medicas
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    horario      TIMESTAMP NOT NULL,
    is_realizada BOOLEAN          DEFAULT FALSE,
    is_ativo BOOLEAN          DEFAULT TRUE,
    medico_id    UUID, --REFERENCES medicos (id) ON DELETE CASCADE,
    paciente_id  UUID, -- REFERENCES pacientes (id) ON DELETE CASCADE,
    valor        DECIMAL(10, 2),
    hospital_id  UUID -- REFERENCES hospital (id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS receitas
(
    id                 UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    paciente_id        UUID, -- REFERENCES pacientes (id) ON DELETE CASCADE,
    consulta_medica_id UUID, -- REFERENCES consultas_medicas (id) ON DELETE CASCADE,
    descricao          TEXT NOT NULL,
    medico_id          UUID -- REFERENCES medicos (id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS procedimentos
(
    id        UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome      VARCHAR(255) NOT NULL,
    descricao TEXT
    );

CREATE TABLE IF NOT EXISTS exames
(
    id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tipo_exame       VARCHAR(255) NOT NULL,
    is_realizada     BOOLEAN          DEFAULT FALSE,
    descricao        TEXT,
    paciente_id      UUID, -- REFERENCES pacientes (id) ON DELETE CASCADE,
    data_solicitacao TIMESTAMP        DEFAULT CURRENT_TIMESTAMP
    );


CREATE TABLE IF NOT EXISTS medicamentos
(
    id            UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome          VARCHAR(255) NOT NULL,
    periodicidade VARCHAR(100),
    dosagem       VARCHAR(100)
    );

-- CREATE TABLE IF NOT EXISTS notificacoes
-- (
--     id               UUID PRIMARY KEY DEFAULT gen_random_uuid(),
--     usuario_id       UUID REFERENCES usuarios (id) ON DELETE CASCADE,
--     hospital_id      UUID REFERENCES hospital (id) ON DELETE CASCADE,
--     tipo             VARCHAR(50) NOT NULL,
--     mensagem         TEXT,
--     data_notificacao TIMESTAMP        DEFAULT CURRENT_TIMESTAMP,
--     lida             BOOLEAN          DEFAULT FALSE
--     );
