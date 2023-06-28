CREATE TABLE ISSUE (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    descripcion VARCHAR(255),
    codigo INT,
    resuelta BOOLEAN,
    gravedad DOUBLE,
    responsable VARCHAR(255),
    fechaCreacion DATE,
    observaciones VARCHAR(255)
);


INSERT INTO ISSUE (nombre, descripcion, codigo, resuelta, gravedad, responsable, fechaCreacion, observaciones)
VALUES ('Issue 1', 'Descripción del problema 1', 123, false, 3.5, 'Responsable 1', '2023-06-01', 'Observaciones 1');
INSERT INTO ISSUE (nombre, descripcion, codigo, resuelta, gravedad, responsable, fechaCreacion, observaciones)
VALUES ('Issue 2', 'Descripción del problema 2', 456, true, 2.8, 'Responsable 2', '2023-06-02', 'Observaciones 2');
INSERT INTO ISSUE (nombre, descripcion, codigo, resuelta, gravedad, responsable, fechaCreacion, observaciones)
VALUES ('Issue 3', 'Descripción del problema 3', 789, false, 1.2, 'Responsable 3', '2023-06-03', 'Observaciones 3');
INSERT INTO ISSUE (nombre, descripcion, codigo, resuelta, gravedad, responsable, fechaCreacion, observaciones)
VALUES ('Issue 4', 'Descripción del problema 4', 101112, true, 4.7, 'Responsable 4', '2023-06-04', 'Observaciones 4');
INSERT INTO ISSUE (nombre, descripcion, codigo, resuelta, gravedad, responsable, fechaCreacion, observaciones)
VALUES ('Issue 5', 'Descripción del problema 5', 131415, false, 2.1, 'Responsable 5', '2023-06-05', 'Observaciones 5');