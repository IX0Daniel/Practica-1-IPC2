DROP DATABASE IF EXISTS pizza_express;
CREATE DATABASE pizza_express;
USE pizza_express;

CREATE TABLE sucursal (
    id_sucursal INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    direccion VARCHAR(150)
)ENGINE=InnoDB;

CREATE TABLE producto (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    descripcion VARCHAR(150) 
);

CREATE TABLE inventario (
    id_sucursal INT NOT NULL,
    id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    estado BOOLEAN NOT NULL,

    CONSTRAINT pk_inventario 
        PRIMARY KEY (id_sucursal, id_producto),

    CONSTRAINT fk_inventario_sucursal 
        FOREIGN KEY (id_sucursal) 
        REFERENCES sucursal(id_sucursal),

    CONSTRAINT fk_inventario_producto 
        FOREIGN KEY (id_producto) 
        REFERENCES producto(id_producto)
);

CREATE TABLE rol (
    id_rol INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL
)ENGINE=InnoDB;

INSERT INTO rol (nombre) VALUES
('SuperAdmin'),
('Administrador'),
('Jugador');

CREATE TABLE usuario (
    id_usuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE,
    password VARCHAR(100) NOT NULL,
    id_rol INT NOT NULL,
    id_sucursal INT NULL,

    FOREIGN KEY (id_rol) REFERENCES rol(id_rol),
    FOREIGN KEY (id_sucursal) REFERENCES sucursal(id_sucursal)
 )ENGINE=InnoDB;

CREATE TABLE jugador (
    id_usuario INT PRIMARY KEY,
    nivel INT DEFAULT 1,
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);


CREATE TABLE pedido (
    id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(20) NOT NULL,

    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
) ENGINE=InnoDB;



CREATE TABLE pedido_detalle (
    id_detalle INT PRIMARY KEY AUTO_INCREMENT,
    id_pedido INT,
    id_producto INT,
    cantidad INT,

    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
) ENGINE=InnoDB;



INSERT INTO usuario (nombre, correo, password, id_rol) VALUES
('IX-ZD', 'superadmin@gmail.com', 'PSWRD', 1);


INSERT INTO sucursal (nombre, direccion) VALUES
('Sucursal Centro', 'Zona 1, Xela'),
('Sucursal Norte', 'Zona 5, Xela'),
('Sucursal Sur', 'Zona 12, Xela');

INSERT INTO producto (nombre, descripcion) VALUES
('Queso', 'Queso para pizza'),
('Piña', 'Para pizza hawaiana'),
('Jamón', 'Jamón cocido rebanado'),
('Pepperoni', 'Embutido estilo italiano'),
('Champiñones', 'Hongos frescos'),
('Aceitunas', 'Aceitunas sin hueso'),
('Salchicha', 'Salchica cortada'),
('Cebolla', 'Rebanadas de cebolla'),
('Orégano', 'Especia seca');

INSERT INTO inventario (id_sucursal, id_producto, cantidad, estado) VALUES
(1, 1, 50, TRUE),
(1, 2, 40, FALSE),
(1, 3, 30, TRUE),
(1, 4, 25, TRUE),
(1, 5, 15, TRUE),
(1, 6, 10, TRUE),
(1, 7, 60, TRUE),
(1, 8, 20, TRUE),
(2, 1, 35, TRUE),
(2, 2, 30, TRUE),
(2, 3, 20, TRUE),
(2, 4, 15, FALSE),
(2, 5, 10, TRUE),
(2, 7, 40, TRUE),
(3, 1, 45, TRUE),
(3, 2, 38, TRUE),
(3, 4, 30, TRUE),
(3, 6, 12, TRUE),
(3, 7, 55, TRUE),
(3, 8, 18, TRUE);
