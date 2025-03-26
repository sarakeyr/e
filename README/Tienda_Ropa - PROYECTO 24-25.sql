-- Borrar la base de datos si existe
DROP DATABASE IF EXISTS Tienda_Ropa;

-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS Tienda_Ropa;

--  Seleccionar la base de datos.
USE Tienda_Ropa;

-- Crear la tabla DEPARTAMENTO
CREATE TABLE DEPARTAMENTO (
    codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL unique key
);

-- Crear la tabla EMPLEADO
CREATE TABLE EMPLEADO (
    DNI CHAR(9) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    telefono char(9),
    f_nacimiento date,
    direccion VARCHAR(255),
    email VARCHAR(100) not null unique key,
    activo BOOLEAN default true,
    tiene_privilegios BOOLEAN,
    pass text not null,
    dpto INT UNSIGNED NOT null,
    FOREIGN KEY (dpto) REFERENCES DEPARTAMENTO (codigo)
);

-- Crear la tabla METODO_PAGO
CREATE TABLE METODO_PAGO (
    codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(50) NOT NULL unique key
);

-- Crear la tabla CLIENTE
CREATE TABLE CLIENTE (
    DNI CHAR(9) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    telefono char(9),
    f_nacimiento date,
    direccion VARCHAR(255),
    email VARCHAR(100) not null unique key,
    activo BOOLEAN default true,
    pass text not null,
    saldo_cuenta float,
    num_pedidos int, 
    dir_envio VARCHAR(255) NOT NULL,
    tarjeta_fidelizacion boolean,
    m_pago INT UNSIGNED NOT NULL,
    foreign key (m_pago) references METODO_PAGO(codigo)
);

-- Crear la tabla PEDIDO
CREATE TABLE PEDIDO (
    numero INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    fecha DATE NOT NULL,
    dir_envio VARCHAR(255) NOT NULL,
    estado ENUM("En proceso","Completado", "Cancelado") NOT NULL,
    m_pago INT UNSIGNED NOT NULL,
    DNI_cliente CHAR(9) NOT NULL,
    FOREIGN KEY (DNI_cliente) REFERENCES CLIENTE(DNI),
    foreign key (m_pago) references METODO_PAGO(codigo)
);

-- Crear la tabla MATERIAL
CREATE TABLE MATERIAL (
    codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    denominacion VARCHAR(50) NOT NULL UNIQUE KEY
);

-- Crear la tabla ARTICULO
CREATE TABLE ARTICULO (
    cod_art int UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    marca VARCHAR(255),
    descripcion TEXT,
    activo boolean default true,
    imagen VARCHAR(25), -- Se almacenará el nombre del archivo
    color VARCHAR (15),
    material INT UNSIGNED,
    FOREIGN KEY (material) REFERENCES MATERIAL(codigo)
);

-- Crear la tabla ROPA
CREATE TABLE ROPA (
	cod_art int UNSIGNED PRIMARY KEY,
    talla_ropa VARCHAR (10),
    tipo_cierre VARCHAR (15), 
    impermeable BOOLEAN, 
    tipo_manga VARCHAR (15), 
    estampada BOOLEAN, 
    tipo_pantalón VARCHAR (15),
    tiene_bolsillos BOOLEAN, 
    tipo_ropa ENUM ("Chaqueta", "Camisa", "Pantalón") NOT NULL,
    FOREIGN KEY (cod_art) REFERENCES ARTICULO (cod_art)
);

-- Crear la tabla ACCESORIOS
CREATE TABLE ACCESORIO (
    cod_art int UNSIGNED PRIMARY KEY,
    estilo VARCHAR(50),
    personalizado BOOLEAN,
    tipo_cierre_bolso VARCHAR(50),
    capacidad INT,
    tipo_suela VARCHAR(50),
    talla_zapato INT,
    tipo_accesorio ENUM ("Zapatos", "Bolso") NOT NULL,
    FOREIGN KEY (cod_art) REFERENCES ARTICULO(cod_art)
);

-- Crear la tabla LINEA_PEDIDO
CREATE TABLE LINEA_PEDIDO (
    cod_art int UNSIGNED,
    num_pedido INT UNSIGNED,
    PRIMARY KEY (cod_art, num_pedido),
    FOREIGN KEY (cod_art) REFERENCES ARTICULO(cod_art),
    FOREIGN KEY (num_pedido) REFERENCES PEDIDO (numero)
);
