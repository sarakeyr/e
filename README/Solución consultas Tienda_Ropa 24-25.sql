-- ================================================================
-- CONSULTAS
-- ================================================================

-- Muestra todos los artículos
select * from articulo;

-- Muestra toda la información sobre TODA la ropa disponible
select *
from articulo join ropa on articulo.cod_art = ropa.cod_art;

-- Muestra toda la información sobre las camisas diponibles
select *
from articulo join ropa on articulo.cod_art = ropa.cod_art
where tipo_ropa = "Camisa";

-- Muestra toda la información sobre las chaquetas diponibles
select *
from articulo join ropa on articulo.cod_art = ropa.cod_art
where tipo_ropa = "Chaqueta";

-- Muestra toda la información sobre los pantalones diponibles
select *
from articulo join ropa on articulo.cod_art = ropa.cod_art
where tipo_ropa = "Pantalón";

-- Muestra toda la información sobre TODOS los accesorios disponibles
select *
from articulo join accesorio on articulo.cod_art = accesorio.cod_art;

-- Muestra toda la información sobre TODOS los zapatos disponibles
select *
from articulo join accesorio on articulo.cod_art = accesorio.cod_art
where tipo_accesorio = "Zapatos";

-- Muestra toda la información sobre TODOS los bolsos disponibles
select *
from articulo join accesorio on articulo.cod_art = accesorio.cod_art
where tipo_accesorio = "Bolso";

-- Muestra toda la información sobre el artículo con código 15
select *
from accesorio right join articulo on articulo.cod_art = accesorio.cod_art
			left join ropa on ropa.cod_art = articulo.cod_art
where articulo.cod_art = 15;

-- Muestra toda la información de los empleados
select * from empleado;

-- Muestra toda la información de los empleados Administradores (los administradores son aquellos empleados que tienen priviliegios)
select * from empleado 
where tiene_privilegios is true;

-- Muestra toda la información de los empleados que trabajan en Administración
select * from empleado
where dpto = (select codigo from departamento where nombre = "Administración");

-- Muestro toda la información del empleado con DNI = 12345678A
select * from empleado where dni like '12345678A';

-- Muestro toda la información del administrador cuyo dni = 90123456I;
select * from empleado 
where tiene_privilegios is true and DNI = '90123456I';

-- Muestra toda la información de los empleados que trabajan en ventas
select * from empleado
where dpto = (select codigo from departamento where nombre = "Ventas");

-- Muestra toda la información de los empleados que trabajan en el almacén
select * from empleado
where dpto = (select codigo from departamento where nombre = "Almacén");

-- Muestra toda la información de los clientes
select * from cliente;

-- Muestra toda la información del cliente con DNI = 12345678J
select * from cliente where dni like '12345678J';

-- Muestra toda la información del cliente cuyo nombre es Carmen, y sus apellidos "López Martínez"
select * from cliente 
where nombre like 'Carmen' and apellidos like 'L_pez Mart_nez'; -- Utilizamos el comodín _ por si en la base de datos está almacenado el dato sin la tilde (´).

-- Muestra toda la información sobre los pedidos (SIN el detalle o líneas de los pedidos).
select * from pedido;

-- Muestra toda la información sobre los pedidos (CON el detalle o líneas de los pedidos y la descripción de los artículos).
select P.*, A.nombre, A.precio from pedido P inner join linea_pedido LP on P.numero = LP.num_pedido inner join articulo A on A.cod_art = LP.cod_art;

-- Muestra la información de los pedidos del cliente con DNI = 01234567I (SIN el detalle o líneas de los pedidos).
select * from pedido where DNI_cliente = '01234567I';

-- Muestra la información de los pedidos del cliente con DNI = 01234567I (CON el detalle o líneas de los pedidos y la descripción de los artículos).
select P.*, A.nombre, A.precio from pedido P inner join linea_pedido LP on P.numero = LP.num_pedido inner join articulo A on A.cod_art = LP.cod_art
where DNI_cliente = '01234567I';

-- Mostrar la información del cliente que ha realizado el pedido número 8,
select C.* from pedido P inner join cliente C on P.DNI_cliente = C.DNI
where numero = 8;

-- Calcular el número de pedidos que ha realizado cada cliente
select dni_cliente, count(*)
from pedido
group by dni_cliente;

-- Calcular el número de pedidos que se han pagado con Bizum
select count(*)
from pedido
where m_pago = (select codigo from metodo_pago where descripcion = "Bizum");

-- ================================================================
-- INSERCIONES
-- ================================================================
-- Insertar un artículo
insert into articulo (nombre, precio, marca, descripcion, activo, imagen, material) 
VALUES ('Pantalón de chandal', 9.99, 'Decathlon', 'Pantalón de chandal punto unisex', true, 'imagen21.jpg', 2);
-- Además será necesario insertar los demás datos en la tabla ropa, pero para eso necesitaremos conocer que cod_art se le ha asignado, dado que es auto-increment
select max(cod_art) from articulo ;
-- Ya podemos insertar los detalles en la tabla ropa
insert into ropa (cod_art, talla, color, tipo_cierre, impermeable, tipo_manga, estampada, tipo_pantalon, tien_bolsillos, tipo_ropa) 
VALUES (21, 'S', 'Negro', 'Goma', NULL, NULL, NULL, 'Chándal', false, 'Pantalón');

-- podríamos hacer la segunda inserción sin hacer previamente la consulta de la siguiente forma
insert into ropa (cod_art, talla, color, tipo_cierre, impermeable, tipo_manga, estampada, tipo_pantalon, tien_bolsillos, tipo_ropa) 
VALUES ((select max(cod_art) from articulo), 'S', 'Negro', 'Goma', NULL, NULL, NULL, 'Chándal', false, 'Pantalón');

-- Insertar un empleado que trabaje en departamento de Admnistración y tenga privilegios
INSERT INTO EMPLEADO (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, activo, tiene_privilegios, pass, dpto) VALUES
('33407774K', 'Jorge', 'Sanz López', '607473813', '1973-08-19', 'Calle Consitución, 66', 'jorge.sanz@example.com', true, TRUE, '123456', (select codigo from departamento where nombre = "Administración"));

-- Insesrtar un cliente nuevo
INSERT INTO CLIENTE (DNI, nombre, apellidos, telefono, f_nacimiento, direccion, email, pass, saldo_cuenta, num_pedidos, dir_envio, tarjeta_fidelizacion, activo, m_pago) 
VALUES ('33456789A', 'María', 'Gómez López', '691223344', '1980-07-25', 'Calle Mayor, 23', 'maria.gomez@example.com', '123456', 100.00, 0, 'Calle Sol, 10', false, true, 1);

-- Insertar método de pago nuevo (necesitaremos saber cual es el último código introducido o ponerlo como autoincrement, que es la opción por la que he optado)
INSERT INTO METODO_PAGO (descripcion) VALUES ('Transferencia');

-- Borrar método de pago "Transferencia"
delete from metodo_pago
where descripcion = "Transferencia";

-- Hay que tener en cuenta que los campos autoincrementables, cuando se elimina una fila de la tabla, el valor que tenia asociado en ese campo, desaparece y no se vuelve a utilizar.
-- Es decir, que si añado transferencia, le asignará el codigo 5, pero al eliminarlo, y volver a insertar otra fila en la tabla, le asignará el codigo 6, y no existirá en nuestra BD el código 5.
-- Para evitar que se puedan introducir dos métodos de pago, material, o departamentos con el mismo nombre (ya que desconocemos el codigo) he indicado que los otros campos (nombre, denominación, descripción) sean UNIQUE KEY,
-- es decir, que no se puedan repetir.
