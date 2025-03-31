CREATE DATABASE aigineer_db;
GRANT ALL PRIVILEGES ON DATABASE aigineer_db TO postgres;

\c aigineer_db

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE celebration
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name text
);

CREATE TABLE style
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name text
);

CREATE TABLE tone
(
    id   uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    name text
);

create table prompt
(
    id             uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    content        text NOT NULL,
    prompt_type    text NOT NULL,
    llm_service_id uuid NOT NULL,
    deleted        boolean NOT NULL DEFAULT FALSE
);

create table llm_service
(
    id           uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    description  text,
    service_name text
);

INSERT INTO llm_service (id, description, service_name) VALUES ('550e8400-e29b-41d4-a716-446655440000',
'Сервис для генерации поздравлений', 'AIGINEER_CGS');

INSERT INTO prompt (content, prompt_type, llm_service_id) VALUES ('
Ты модель для поздравления людей с праздниками, сделай поздравление на праздник [%s] для получателя с именем [%s], а так же используй следующий окрас поздравления:
- Стиль поздравления: %s
- Тон поздравления: %s
Учти дополнительные пожелания, если они присутствуют ниже:
[%s]
', 'GENERATIVE', '550e8400-e29b-41d4-a716-446655440000');

INSERT INTO celebration (name) VALUES ('День Рождения');
INSERT INTO celebration (name) VALUES ('Новый год');
INSERT INTO celebration (name) VALUES ('День матери');
INSERT INTO celebration (name) VALUES ('Международный женский день');
INSERT INTO celebration (name) VALUES ('День защитника отечества');
INSERT INTO celebration (name) VALUES ('День победы');
INSERT INTO celebration (name) VALUES ('День учителя');
INSERT INTO celebration (name) VALUES ('Масленица');
INSERT INTO celebration (name) VALUES ('Рождество Христово');
INSERT INTO celebration (name) VALUES ('День России');
INSERT INTO celebration (name) VALUES ('День народного единства');
INSERT INTO celebration (name) VALUES ('День знаний');
INSERT INTO celebration (name) VALUES ('День космонавтики');
INSERT INTO celebration (name) VALUES ('День семьи, любви и верности');


INSERT INTO style (name) VALUES ('Короткий и лаконичный');
INSERT INTO style (name) VALUES ('Официальный');
INSERT INTO style (name) VALUES ('Неофициальный');
INSERT INTO style (name) VALUES ('Эмоциональный');
INSERT INTO style (name) VALUES ('Научный');
INSERT INTO style (name) VALUES ('Юмористический');

INSERT INTO tone (name) VALUES ('Теплый');
INSERT INTO tone (name) VALUES ('Нейтральный');
INSERT INTO tone (name) VALUES ('Возвышенный');
INSERT INTO tone (name) VALUES ('Воодушевляющий');
INSERT INTO tone (name) VALUES ('Утешительный');
INSERT INTO tone (name) VALUES ('Осторожный');