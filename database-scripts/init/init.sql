CREATE DATABASE aigineer_db;
GRANT ALL PRIVILEGES ON DATABASE aigineer_db TO postgres;

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

INSERT INTO celebration (id, name) VALUES ('32e755e4-d742-4ece-baa9-b16aa7fbe5ae','День Рождения');

INSERT INTO style (id, name) VALUES ('418f0551-5609-40fb-a77f-84265f4b1c92','Короткий и лаконичный');

INSERT INTO tone (id, name) VALUES ('4889668a-9305-4648-bd44-0f3177b9a7e3','Теплый');