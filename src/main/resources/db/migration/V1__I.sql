CREATE TABLE IF NOT EXISTS distribuidor (
    id serial,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(45) NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS servicio (
    id serial,
    description VARCHAR(45) NOT NULL,
    details VARCHAR(45) NULL,
    distribuidor_id int,
    FOREIGN key (distribuidor_id)
    REFERENCES distribuidor(id)
    );

CREATE TABLE IF NOT EXISTS cliente (
    id serial,
    Nombre VARCHAR(45) NOT NULL,
    Fecha VARCHAR(45) NULL,
    distribuidor_id int,
    FOREIGN key (distribuidor_id)
    REFERENCES distribuidor(id)
    );


