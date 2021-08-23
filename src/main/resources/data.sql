drop table if exists salas ;
drop table if exists peliculas;

create table peliculas (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(100),
    calificacion_edad int,
    PRIMARY KEY (id)
);

create table salas (
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(100),
    id_pelicula int,
    PRIMARY KEY(id),
    CONSTRAINT salas_fk FOREIGN KEY (id_pelicula) REFERENCES peliculas(id)
);

insert into peliculas(nombre, calificacion_edad)values('El señor de los anillos', 12);
insert into peliculas(nombre, calificacion_edad)values('El exorcista', 18);
insert into peliculas(nombre, calificacion_edad)values('Armageddon', 12);
insert into peliculas(nombre, calificacion_edad)values('Avatar', 8);
insert into peliculas(nombre, calificacion_edad)values('Inside out', 6);

insert into salas(nombre, id_pelicula) values ('SALA 1', '1');
insert into salas(nombre, id_pelicula) values ('SALA 2', '2');
insert into salas(nombre, id_pelicula) values ('SALA 3', '3');
insert into salas(nombre, id_pelicula) values ('SALA 4', '4');
insert into salas(nombre, id_pelicula) values ('SALA 5', '5');
