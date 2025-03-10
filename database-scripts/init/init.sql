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
    content        text,
    prompt_type    text,
    llm_service_id uuid,
    deleted        boolean
);

create table llm_service
(
    id           uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    description  text,
    service_name text
);

