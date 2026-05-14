-- 1. Creamos la base de datos (si no existe) y la usamos
CREATE DATABASE IF NOT EXISTS JPA_Repaso;
USE JPA_Repaso;

-- 2. Tabla Cliente
CREATE TABLE IF NOT EXISTS Cliente (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    telefono VARCHAR(255),
    email VARCHAR(255)
);

-- 3. Tabla Barbero
CREATE TABLE IF NOT EXISTS Barbero (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    apellido VARCHAR(255),
    especialidad VARCHAR(255)
);

-- 4. Tabla Servicio
CREATE TABLE IF NOT EXISTS Servicio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255),
    precio DECIMAL(10, 2)
);

-- 5. Tabla Cita (Aquí ocurre la magia de las claves foráneas)
CREATE TABLE IF NOT EXISTS cita (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    fecha_hora DATETIME,
    estado VARCHAR(255),
    notas VARCHAR(255),
    cliente_id BIGINT,
    barbero_id BIGINT,
    servicio_id BIGINT,
    
    -- Restricciones de Claves Foráneas (Relaciones)
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id),
    FOREIGN KEY (barbero_id) REFERENCES Barbero(id),
    FOREIGN KEY (servicio_id) REFERENCES Servicio(id)
);


-- ==========================================
-- DATOS DE PRUEBA (Para que tu App.java funcione)
-- ==========================================

-- Insertamos al Cliente con ID 1
INSERT INTO Cliente (nombre, apellido, telefono, email) 
VALUES ('Juan', 'Perez', '0991234567', 'juan@email.com');

-- Insertamos al Barbero con ID 1
INSERT INTO Barbero (nombre, apellido, especialidad) 
VALUES ('Carlos', 'Tijeras', 'Corte Clásico');

-- Insertamos el Servicio con ID 1
INSERT INTO Servicio (nombre, precio) 
VALUES ('Corte de cabello y barba', 15.50);