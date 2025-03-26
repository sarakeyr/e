-- Insertar datos en la tabla DEPARTAMENTO
INSERT INTO DEPARTAMENTO (codigo, nombre) VALUES
(2, 'Ventas'),
(1, 'Administración'),
(3, 'Almacén');

-- Insertar datos en la tabla EMPLEADO
INSERT INTO EMPLEADO (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, activo, tiene_privilegios, pass, dpto) VALUES
('12345678A', 'Ana', 'González López', '611223344', '1990-07-15', 'Calle Mayor, 123', 'ana.gonzalez@example.com', true, TRUE, '123456', 1),
('23456789B', 'Pedro', 'Martínez García', '633445566', '1988-09-20', 'Avenida Libertad, 45', 'pedro.martinez@example.com', true, false, '123456', 2),
('34567890C', 'María', 'Fernández Pérez', '655667788', '1995-04-08', 'Plaza España, 7', 'maria.fernandez@example.com',  true, false, '123456', 2),
('45678901D', 'Carlos', 'Sánchez Rodríguez', '677889900', '1993-01-25', 'Calle Gran Vía, 8', 'carlos.sanchez@example.com',  false, false, '123456', 3),
('56789012E', 'Laura', 'Díaz Martínez', '699001122', '1992-11-10', 'Calle Sol, 10', 'laura.diaz@example.com',  true, false, '123456', 3),
('67890123F', 'David', 'Gómez Fernández', '622334455', '1987-06-05', 'Avenida del Parque, 20', 'david.gomez@example.com',  true, false, '123456', 3),
('78901234G', 'Sandra', 'López Martínez', '644556677', '1991-03-20', 'Calle Gran Vía, 8', 'sandra.lopez@example.com',  true, false, '123456', 3),
('89012345H', 'Javier', 'Pérez García', '677889900', '1994-08-15', 'Avenida Libertad, 45', 'javier.perez@example.com',  true, false, '123456', 3),
('90123456I', 'Elena', 'Hernández Ruiz', '655667788', '1989-12-10', 'Plaza España, 7', 'elena.hernandez@example.com',  true, true, '123456', 2),
('01234567J', 'Raúl', 'González Pérez', '699001122', '1985-07-25', 'Calle Mayor, 123', 'raul.gonzalez@example.com',  true, false, '123456', 3),
('12345678K', 'Nuria', 'Martínez Gómez', '622334455', '1993-04-10', 'Calle Sol, 10', 'nuria.martinez@example.com', true, false, '123456', 2),
('23456789L', 'Jorge', 'Sánchez Rodríguez', '644556677', '1988-01-15', 'Avenida del Parque, 20', 'jorge.sanchez@example.com',  true,false, '123456', 2),
('34567890M', 'Carmen', 'López Martínez', '677889900', '1992-09-20', 'Calle Gran Vía, 8', 'carmen.lopez@example.com',  true, false, '123456', 3),
('45678901N', 'Mario', 'Pérez García', '699001122', '1987-06-05', 'Avenida Libertad, 45', 'mario.perez@example.com',  true, true, '123456', 1),
('56789012O', 'Sofía', 'Hernández Ruiz', '622334455', '1990-03-15', 'Plaza España, 7', 'sofia.hernandez@example.com',  true, false, '123456', 2);

-- Insertar datos en la tabla METODO_PAGO
INSERT INTO METODO_PAGO (codigo, descripcion) VALUES
(1, 'Efectivo'),
(2, 'Tarjeta'),
(3, 'PayPal'),
(4, 'Bizum');

-- Insertar datos en la tabla CLIENTE
INSERT INTO CLIENTE (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, pass, saldo_cuenta, num_pedidos, dir_envio, tarjeta_fidelizacion, m_pago) VALUES
('23456789A', 'María', 'González López', '611223344', '1990-07-15', 'Calle Mayor, 123', 'maria.gonzalez@example.com', '123456', 1000.00, 2, 'Calle Sol, 10', true, 1),
('34567890B', 'Pedro', 'Martínez García', '633445566', '1988-09-20', 'Avenida Libertad, 45', 'pedro.martinez@example.com', '123456', 500.00, 4, 'Avenida del Parque, 20', false, 2),
('45678901C', 'Laura', 'Fernández Pérez', '655667788', '1995-04-08', 'Plaza España, 7', 'laura.fernandez@example.com', '123456', 750.00, 3, 'Plaza España, 7', true, 3),
('56789012D', 'Carlos', 'Sánchez Rodríguez', '677889900', '1993-01-25', 'Calle Gran Vía, 8', 'carlos.sanchez@example.com', '123456', 1200.00, 5, 'Calle Mayor, 123', false, 4),
('67890123E', 'Ana', 'Díaz Martínez', '699001122', '1992-11-10', 'Avenida Libertad, 45', 'ana.diaz@example.com', '123456', 850.00, 2, 'Calle Sol, 10', true, 1),
('78901234F', 'David', 'Gómez Fernández', '622334455', '1987-06-05', 'Avenida del Parque, 20', 'david.gomez@example.com', '123456', 300.00, 1, 'Avenida Libertad, 45', false, 2),
('89012345G', 'Sandra', 'López Martínez', '644556677', '1991-03-20', 'Calle Gran Vía, 8', 'sandra.lopez@example.com', '123456', 2000.00, 7, 'Plaza España, 7', true, 3),
('90123456H', 'Javier', 'Pérez García', '677889900', '1994-08-15', 'Calle Mayor, 123', 'javier.perez@example.com', '123456', 600.00, 3, 'Avenida del Parque, 20', false, 4),
('01234567I', 'Elena', 'Hernández Ruiz', '655667788', '1989-12-10', 'Plaza España, 7', 'elena.hernandez@example.com', '123456', 1800.00, 6, 'Avenida Libertad, 45', true, 1),
('12345678J', 'Raúl', 'González Pérez', '699001122', '1985-07-25', 'Avenida del Parque, 20', 'raul.gonzalez@example.com', '123456', 950.00, 4, 'Calle Mayor, 123', false, 1),
('23456789K', 'Nuria', 'Martínez Gómez', '622334455', '1993-04-10', 'Calle Sol, 10', 'nuria.martinez@example.com', '123456', 1300.00, 2, 'Avenida Libertad, 45', true, 1),
('34567890L', 'Jorge', 'Sánchez Rodríguez', '644556677', '1988-01-15', 'Calle Gran Vía, 8', 'jorge.sanchez@example.com', '123456', 400.00, 3, 'Plaza España, 7', false, 2),
('45678901M', 'Carmen', 'López Martínez', '677889900', '1992-09-20', 'Plaza España, 7', 'carmen.lopez@example.com', '123456', 750.00, 5, 'Calle Mayor, 123', true, 3),
('56789012N', 'Mario', 'Pérez García', '699001122', '1987-06-05', 'Calle Mayor, 123', 'mario.perez@example.com', '123456', 1100.00, 4, 'Avenida Libertad, 45', false, 4),
('67890123O', 'Sofía', 'Hernández Ruiz', '622334455', '1990-03-15', 'Avenida del Parque, 20', 'sofia.hernandez@example.com', '123456', 1600.00, 2, 'Calle Sol, 10', true, 1);

-- Inserción de valores en la tabla PEDIDO
INSERT INTO PEDIDO (fecha, dir_envio, estado, m_pago, DNI_cliente) VALUES
('2024-03-15', 'Calle Gran Vía, 30', 'En proceso', 1, '23456789A'),
('2024-03-14', 'Calle Mayor, 50', 'Completado', 2, '34567890B'),
('2024-03-13', 'Avenida del Parque, 20', 'En proceso', 3, '45678901C'),
('2024-03-12', 'Plaza España, 7', 'Cancelado', 4, '56789012D'),
('2024-03-11', 'Calle Sol, 10', 'Completado', 1, '67890123E'),
('2024-03-10', 'Avenida Libertad, 45', 'En proceso', 2, '78901234F'),
('2024-03-09', 'Calle Gran Vía, 8', 'En proceso', 3, '89012345G'),
('2024-03-08', 'Plaza España, 7', 'Completado', 4, '90123456H'),
('2024-03-07', 'Avenida del Parque, 20', 'En proceso', 1, '01234567I'),
('2024-03-06', 'Calle Mayor, 123', 'Completado', 2, '12345678J');

-- Insertar datos en la tabla MATERIAL
INSERT INTO MATERIAL (codigo, denominacion) VALUES
(1, 'Algodón'),
(2, 'Poliéster'),
(3, 'Seda'),
(4, 'Cuero'),
(5, 'Lana'),
(6, 'Pana'),
(7, 'Franela'),
(8, 'Lino'),
(9, 'Cachemira'),
(10, 'Terciopelo');

-- Inserción de valores en la tabla ARTICULO
INSERT INTO ARTICULO (nombre, precio, marca, descripcion, activo, imagen, color, material) VALUES
('Camisa básica', 15.99, 'Zara', 'Camiseta de algodón unisex', true, 'imagen1.jpg', 'blanco', 1), -- 1
('Pantalón vaquero', 29.99, 'H&M', 'Pantalón vaquero de corte recto', true, 'imagen2.jpg','azul', 2), -- 2
('Zapatos de cuero', 49.99, 'Clarks', 'Zapatos de cuero negro para hombre', true, 'imagen3.jpg','negro', 4), -- 3
('Camisa estampada', 39.99, 'Mango', 'Camisa manga corta con estampado floral', true, 'imagen4.jpg', 'verde',3), -- 4
('Cazadora bomber', 59.99, 'Pull&Bear', 'Cazadora bomber acolchada', true, 'imagen5.jpg', 'caqui',2), -- 5
('Zapatillas deportivas', 34.99, 'Nike', 'Zapatillas deportivas para correr', true,'imagen6.jpg', 'azul', 5), -- 6
('Cahqueta de lana', 45.99, 'Massimo Dutti', 'Jersey de lana merino con cuello redondo', true,'imagen7.jpg','camel', 6), -- 7
('Bolso de piel', 79.99, 'Michael Kors', 'Bolso de piel sintética color camel', true, 'imagen8.jpg','camel',4), -- 8
('Polo de algodón', 25.99, 'Lacoste', 'Polo de algodón piqué con el logo de Lacoste', true,'imagen9.jpg','rosa', 1), -- 9
('Falda pantalón plisada', 35.99, 'Stradivarius', 'Falda-pantalón midi plisada de talle alto', true,'imagen10.jpg','negro', 2), -- 10
('Chaqueta de piel', 99.99, 'Bershka', 'Chaqueta biker de piel sintética', true, 'imagen11.jpg','negro',4), -- 11
('Bolso de lana', 19.99, 'Uniqlo', 'Bolso de lana suave y cálida', true, 'imagen12.jpg','azul',5), -- 12
('Sudadera con capucha', 29.99, 'Adidas', 'Sudadera con capucha y logo Adidas', true,'imagen13.jpg', 'blanco',1), -- 13
('Botines de ante', 69.99, 'Timberland', 'Botines de ante impermeables', true,'imagen14.jpg', 'marrón',3), -- 14
('Pantalón cargo', 20.99, 'Zara', 'Pantalón cargo para mujer', true,'imagen15.jpg','caqui', 1), -- 15
('Bolso de cuero', 89.99, 'Michael Kors', 'Bolso de cuero genuino en color negro', true, 'imagen16.jpg','negro', 4), -- 16
('Chaqueta impermeable', 59.99, 'North Face', 'Chaqueta impermeable para actividades al aire libre', true, 'imagen17.jpg','azul',2), -- 17
('Camisa a rayas', 29.99, 'H&M', 'Camisa de algodón a rayas para hombre', true, 'imagen18.jpg','azul',1), -- 18
('Bolso de tela', 49.99, 'Stradivarius', 'Bolso de tela con estampado floral', true, 'imagen19.jpg','rojo',10), -- 19
('Zapatos deportivos', 69.99, 'Nike', 'Zapatos deportivos para correr',true,'imagen20.jpg', 'amarillo',5); -- 20


-- Inserción de valores en la tabla ROPA
INSERT INTO ROPA (cod_art, talla_ropa, tipo_cierre, impermeable, tipo_manga, estampada, tipo_pantalon, tiene_bolsillos, tipo_ropa) VALUES
(1, 'M', 'Botones', NULL, 'Manga corta', false, NULL, NULL, 'Camisa'),
(2, 'L','Cremallera', NULL, NULL, NULL, 'Vaquero', true, 'Pantalón'),
(4, 'XL', 'Botones', NULL, 'Manga larga', true, NULL, NULL, 'Camisa'),
(5, 'L', 'Cremallera', true, NULL, NULL, NULL, NULL, 'Chaqueta'),
(7, 'S', 'Cinturón', false, NULL, NULL, NULL, null, 'Chaqueta'),
(9, 'S', 'Botones', NULL, 'Manga corta', false, NULL, NULL, 'Camisa'),
(10, 'M', 'Cinturón', NULL, NULL, NULL, 'Falda-pantalón', true, 'Pantalón'),
(11, 'XL', 'Cremallera', false, NULL, null, NULL, NULL, 'Chaqueta'),
(13, 'L', 'Botones', NULL,'Manga larga', false, NULL, NULL, 'Camisa'),
(15, 'S', 'Cinturón', NULL, NULL, null, 'Cargo', true, 'Pantalón'),
(17, 'M', 'Cremallera', true, NULL, null, NULL, NULL, 'Chaqueta'),
(18, 'M', 'Botones', NULL, 'Manga larga', true, NULL, NULL, 'Camisa');

-- Inserción de valores en la tabla ACCESORIO
INSERT INTO ACCESORIO (cod_art, estilo, personalizado, tipo_cierre_bolso, capacidad, tipo_suela, talla_zapato, tipo_accesorio) VALUES
(3, 'Clásico', false, NULL, NULL, 'Suela de cuero', 38, 'Zapatos'),
(6, 'Casual', false, NULL, NULL, 'Suela de goma', 38, 'Zapatos'),
(8, 'Elegante', false, 'Cremallera', 20, NULL, NULL, 'Bolso'),
(12, 'Deportivo', false, 'Cordones', 10, NULL, NULL, 'Bolso'),
(14 , 'Elegante', false, NULL, NULL, 'Suela de cuero', 42, 'Zapatos'),
(16, 'Casual', false, 'Clic', 25, NULL, NULL, 'Bolso'),
(19, 'Casual', false, 'Cremallera', 30, NULL, NULL, 'Bolso'),
(20, 'Casual', false, NULL, NULL, 'Suela de goma', 41, 'Zapatos');

-- Inserción de valores en la tabla LINEA_PEDIDO
INSERT INTO LINEA_PEDIDO (cod_art, num_pedido) VALUES
(1, 1), (16, 1), (2, 1),
(3, 2), (18,2), (4, 2), 
(19, 3),
(5, 4), 
(20, 5), (6, 5), 
(10, 6),
(7, 7), (9, 7), (8, 7), 
(12, 8), (14, 8), (15, 8),
(11, 9), 
(13, 10), (17, 10);
