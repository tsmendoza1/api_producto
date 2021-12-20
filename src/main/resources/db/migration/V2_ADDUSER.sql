CREATE TABLE IF NOT EXISTS users (
    id serial primary key,
    username varchar (40) not null,
    password varchar (30) not null,
    unique (username),
    distribuidor_id int,
    FOREIGN key (distribuidor_id)
    REFERENCES distribuidor(id)
);

ALTER TABLE users (
    ADD cedula varchar (10)
    );