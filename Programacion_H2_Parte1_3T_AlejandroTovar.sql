CREATE DATABASE cine_AlejandroTovar;
USE cine_AlejandroTovar;

CREATE TABLE pelicula (
    id INT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    duracion INT NOT NULL,
    genero VARCHAR(50),
    idioma VARCHAR(50),
    id_sala INT,
    FOREIGN KEY (id_sala) REFERENCES salas(id)
);

CREATE TABLE sala (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    capacidad INT
);
INSERT INTO sala (id, nombre, capacidad) VALUES
(1, 'Sala 1', 100),
(2, 'Sala 2', 80);

INSERT INTO pelicula (id, titulo, duracion, genero, idioma, id_sala) VALUES
(1, 'Inception', 148, 'Ciencia ficción', 'Inglés', 1),
(2, 'Coco', 105, 'Animación', 'Español', 2);

SHOW TABLES;
SELECT * FROM pelicula;

