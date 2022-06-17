DROP DATABASE IF EXISTS appfut;

CREATE DATABASE IF NOT EXISTS appfut;

USE appfut;

CREATE TABLE IF NOT EXISTS Ligas(
		idLiga INTEGER PRIMARY KEY AUTO_INCREMENT, 
                nombre VARCHAR(50),
                pais VARCHAR(50));
                
CREATE TABLE IF NOT EXISTS Equipos (
                idEquipo INTEGER PRIMARY KEY AUTO_INCREMENT, 
                nombre VARCHAR(50), 
                estadio VARCHAR(50), 
                puntuacion INTEGER, 
                idLiga INTEGER, 
                FOREIGN KEY (idLiga) REFERENCES Ligas(idLiga));

CREATE TABLE IF NOT EXISTS Jugadores (
		idJugador INTEGER PRIMARY KEY AUTO_INCREMENT, 
                nombre VARCHAR(50), 
                apellido VARCHAR(50), 
                fechaNacimiento VARCHAR(50), 
                dorsal INTEGER, 
                nacionalidad VARCHAR(50), 
                posicion VARCHAR(50), 
                valorMercado INTEGER, 
                idEquipo INTEGER, 
                FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo));
                
CREATE TABLE IF NOT EXISTS Partidos(
		idPartido INTEGER PRIMARY KEY AUTO_INCREMENT,  
                numeroJornada INTEGER, 
                fecha VARCHAR(50), 
                resultado INTEGER, 
                idEquipoLocal INTEGER, 
                idEquipoVisitante INTEGER, 
                FOREIGN KEY (idEquipoLocal) REFERENCES Equipos(idEquipo), 
                FOREIGN KEY (idEquipoVisitante) REFERENCES Equipos(idEquipo));
                
CREATE TABLE IF NOT EXISTS Clasificaciones(
		idClasificacion INTEGER PRIMARY KEY AUTO_INCREMENT,  
                posicion INTEGER,  
                nombre VARCHAR(50),  
                partidosJugados INTEGER,  
                partidosGanados INTEGER,  
                partidosEmpatados INTEGER,  
                partidosPerdidos INTEGER,  
                golesFavor INTEGER,  
                golesContra INTEGER,  
                idEquipo INTEGER,  
                FOREIGN KEY (idEquipo) REFERENCES Equipos(idEquipo));

INSERT INTO Ligas(nombre, pais)
VALUES("Ligue 1 Uber Eats", "Francia");

INSERT INTO Ligas(nombre, pais)
VALUES("Bundesliga", "Alemania");

INSERT INTO Equipos(nombre, estadio, puntuacion, idLiga)
VALUES("Real Madrid", "Santiago Bernabeu", 60, 1);

INSERT INTO Equipos(nombre, estadio, puntuacion, idLiga)
VALUES("Atletico de Madrid", "Wanda Metropolitano", 50, 1);

INSERT INTO Jugadores(nombre, apellido, fechaNacimiento, dorsal, nacionalidad, posicion, valorMercado, idEquipo)
VALUES('Cristiano Ronaldo', 'Dos Santos', '01-01-1985', 7, 'Portugal', 'Delantero Centro', 100000000, 1);

INSERT INTO Jugadores(nombre, apellido, fechaNacimiento, dorsal, nacionalidad, posicion, valorMercado, idEquipo)
VALUES('Ronaldo', 'Nazario', '01-01-1985', 9, 'Brasil', 'Delantero Centro', 200000000, 1);

INSERT INTO Jugadores(nombre, apellido, fechaNacimiento, dorsal, nacionalidad, posicion, valorMercado, idEquipo)
VALUES('Luka', 'Modric', '01-01-1985', 10, 'Croacia', 'Mediocentro', 300000000, 1);
