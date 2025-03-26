package com.iescamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUtil {

    //creacion de clases sueltas
    public static MetodoPago crearMetodoPago(){
        System.out.println("Nuevo metodo de Pago: ");

        int codigo = ConsoleReader.readInt("Inserta el código del metodo de pago");
        String descripcion = ConsoleReader.readString("Inserta la descripcion del Metodo de pago");

        return new MetodoPago(codigo,descripcion);

    }

    public static Material crearMaterial(){
        System.out.println("Nuevo material: ");


        int codigo = ConsoleReader.readInt("Dame el código del material");
        String denominacion = ConsoleReader.readString("Dame la denominacion del Metodo de pago");

        return new Material(codigo, denominacion);
    }

    public static Departamento crearDepartamento(){
        System.out.println("Nuevo departamento: ");

        int codigo = ConsoleReader.readInt("Dame el codigo del departamento");
        String nombre = ConsoleReader.readString("Dame el nombre del repartamento");

        return new Departamento(codigo,nombre);
    }

    public static LineaPedido crearLineaPedido(Articulo articulo, Pedido pedido) {
        System.out.println("Creando Línea de Pedido...");
        return new LineaPedido(articulo,pedido);
    }

    //Creacion de usuarios
    public static Cliente crearCliente(MetodoPago metodoPago){
        System.out.println("Nuevo cliente: ");

        String dni = ConsoleReader.readString("Inserta el DNI: ");
        String nombre = ConsoleReader.readString("Inserta el nombre: ");
        String apellidos  = ConsoleReader.readString("Inserta los apellidos ");
        String direccion = ConsoleReader.readString("Inserta la direccion: ");
        String telefono = ConsoleReader.readString("Inserta el telefono: ");
        String e_mail = ConsoleReader.readString("Inserta el email: ");
        LocalDate f_nacimiento = LocalDate.parse(ConsoleReader.readString("Inserta la fecha en el formato DD-MM-YYYY: "));
        String pass = ConsoleReader.readString("Inserta la contraseña: ");
        boolean activo =ConsoleReader.readBoolean("Esta activo? ");


        String dir_envio = ConsoleReader.readString("Inserta la direccion de envio");
        float saldoCuenta = ConsoleReader.readFloat("Inserta el saldo de cuenta");
        boolean tarjeta_fidelizacion= ConsoleReader.readBoolean("Dispone de tarjeta de fidelidad? ");
        int num_pedidos = ConsoleReader.readInt("Inserta el numero de Pedidos realizados: ");


        return new Cliente(dni,nombre,apellidos,direccion,telefono,e_mail, f_nacimiento,
                pass,activo, dir_envio, saldoCuenta,tarjeta_fidelizacion, num_pedidos,metodoPago);
    }

    public static Empleado crearEmpleado(Departamento departamento){

        System.out.println("Nuevo Empleado: ");

        String dni = ConsoleReader.readString("Inserta el DNI: ");
        String nombre = ConsoleReader.readString("Inserta el nombre: ");
        String apellidos  = ConsoleReader.readString("Inserta los apellidos ");
        String direccion = ConsoleReader.readString("Inserta la direccion: ");
        String telefono = ConsoleReader.readString("Inserta el telefono: ");
        String e_mail = ConsoleReader.readString("Inserta el email: ");
        LocalDate f_nacimiento = LocalDate.parse(ConsoleReader.readString("Inserta la fecha en el formato DD-MM-YYYY: "));
        String pass = ConsoleReader.readString("Inserta la contraseña: ");
        boolean activo =ConsoleReader.readBoolean("Esta activo? ");
        boolean tienePrivilegios = ConsoleReader.readBoolean("Tiene privilegios? (true/false)");

        return new Empleado(dni,nombre,apellidos,direccion,telefono,e_mail,f_nacimiento,pass,activo,tienePrivilegios,departamento);
    }

    //Creacion de articulos
    public static Bolso crearBolso(Material material) {
        System.out.println("Creando un nuevo bolso...");


        int cod_art = ConsoleReader.readInt("Introduce el código del bolso:");
        String nombre = ConsoleReader.readString("Introduce el nombre del bolso:");
        float precio = ConsoleReader.readFloat("Introduce el precio del bolso:");
        String marca = ConsoleReader.readString("Introduce la marca del bolso:");
        String descripcion = ConsoleReader.readString("Introduce la descripción del bolso:");
        String imagen = ConsoleReader.readString("Introduce la ruta de la imagen del bolso:");

        String color = ConsoleReader.readString("Introduce el color: ");
        boolean activo = ConsoleReader.readBoolean("¿El bolso está activo? (true/false):");

        String estilo = ConsoleReader.readString("Introduce el estilo del bolso:");
        boolean personalizado = ConsoleReader.readBoolean("¿El bolso es personalizado? (true/false):");

        String cierre_bolso = ConsoleReader.readString("Introduce el tipo de cierre del bolso:");
        int capacidad = ConsoleReader.readInt("Introduce la capacidad en litros del bolso:");

        return new Bolso(cod_art, nombre, precio, marca, descripcion, imagen,color,
                activo,estilo, material, personalizado, cierre_bolso, capacidad,TipoAccesorio.BOLSO);
    }

    public static Zapato crearZapatos(Material material){
        System.out.println("Creando un Zapato...");

        int cod_art = ConsoleReader.readInt("Introduce el código de los zapatos:");
        String nombre = ConsoleReader.readString("Introduce el nombre de los zapatos:");
        float precio = ConsoleReader.readFloat("Introduce el precio de los zapatos:");
        String marca = ConsoleReader.readString("Introduce la marca de los zapatos:");
        String descripcion = ConsoleReader.readString("Introduce la descripción de los zapatos:");
        String imagen = ConsoleReader.readString("Introduce la ruta de la imagen de los zapatos:");

        String color = ConsoleReader.readString("Introduce el color: ");
        boolean activo = ConsoleReader.readBoolean("Los zapatos estan en activo? (true/false)");

        String estilo = ConsoleReader.readString("Introduce el estilo del zapatos");
        boolean personalizado = ConsoleReader.readBoolean("Introduce si los zapatos es personalizado (true/false)");
        String tipo_suela = ConsoleReader.readString("Introduce la talla del zapato");
        int talla_zapatos = ConsoleReader.readInt("Introduce el tipo de suela que tiene el zapato");

        return new Zapato(cod_art, nombre, precio, marca, descripcion,imagen,color, activo,estilo,
                material,personalizado,talla_zapatos,tipo_suela,TipoAccesorio.ZAPATOS );
    }

    public static Camisa crearCamisa(Material material){
        System.out.println("Creando una nueva camisa...");

        int cod_art = ConsoleReader.readInt("Introduce el código de la camisa:");
        String nombre = ConsoleReader.readString("Introduce el nombre de la camisa:");
        float precio = ConsoleReader.readFloat("Introduce el precio de la camisa:");
        String marca = ConsoleReader.readString("Introduce la marca de la camisa:");
        String descripcion = ConsoleReader.readString("Introduce la descripción de la camisa:");
        String imagen = ConsoleReader.readString("Introduce la ruta de la imagen de la camisa:");

        String color = ConsoleReader.readString("Introduce el color: ");
        boolean activo = ConsoleReader.readBoolean("La camisa esta en activo? (true/false)");

        String talla_ropa = ConsoleReader.readString("¿Que talla tiene la camisa?");
        String tipo_cierre = ConsoleReader.readString("Introduce el tipo de cierre de la camisa");
        String tipo_manga = ConsoleReader.readString("Introduce el tipo de manga que tiene la camisa");
        boolean estampada = ConsoleReader.readBoolean("La camisa tiene estampado? (true/false)");

        return new Camisa( cod_art, nombre,precio,
                marca, descripcion, imagen, color, activo,
                material, talla_ropa, tipo_cierre, tipo_manga, estampada, TipoRopa.CAMISA);
    }

    public static Chaqueta crearChaqueta(Material material){

        System.out.println("Creando una nueva chaqueta ");
        int cod_art = ConsoleReader.readInt("Introduce el código del bolso:");
        String nombre = ConsoleReader.readString("Introduce el nombre del bolso:");
        float precio = ConsoleReader.readFloat("Introduce el precio del bolso:");
        String marca = ConsoleReader.readString("Introduce la marca del bolso:");
        String descripcion = ConsoleReader.readString("Introduce la descripción del bolso:");
        String imagen = ConsoleReader.readString("Introduce la ruta de la imagen del bolso:");

        String color = ConsoleReader.readString("Introduce el color de la chaqueta");
        boolean activo = ConsoleReader.readBoolean("La camisa estan en activo? (true/false)");

        String talla_ropa = ConsoleReader.readString("¿Que talla tiene la camisa?");
        String tipo_cierre = ConsoleReader.readString("Introduce el tipo de cierre que la chaqueta");
        boolean impermeable = ConsoleReader.readBoolean("Introduce si la chauqeta es impermeable (true/flase)");

        return new  Chaqueta(cod_art,nombre,precio,marca,descripcion,
                imagen,color,activo,material, talla_ropa, tipo_cierre, TipoRopa.CHAQUETA,
                impermeable);
    }

    public static Pantalon crearPantalon(Material material){

        System.out.println("Creando una nueva chaqueta ");
        int cod_art = ConsoleReader.readInt("Introduce el código del pantalon:");
        String nombre = ConsoleReader.readString("Introduce el nombre del pantalon:");
        float precio = ConsoleReader.readFloat("Introduce el precio del pantalon:");
        String marca = ConsoleReader.readString("Introduce la marca del pantalon:");
        String descripcion = ConsoleReader.readString("Introduce la descripción del pantalon:");
        String imagen = ConsoleReader.readString("Introduce la ruta de la imagen del pantalon:");
        //material
        String color = ConsoleReader.readString("Introduce el color del pantalon");
        boolean activo = ConsoleReader.readBoolean("El pantalon estan en activo? (true/false)");
        //array
        String talla_ropa = ConsoleReader.readString("¿Que talla tiene la camisa?");
        String tipo_cierre = ConsoleReader.readString("Introduce el tipo de cierre que tiene el pantalon");
        boolean tiene_bolsillo = ConsoleReader.readBoolean("Tiene bolsillos este pantalon? (true/false)");
        String tipo_pantalon = ConsoleReader.readString("Introduce que tipo de Pantalon es");

        return new Pantalon(cod_art, nombre, precio, marca, descripcion, imagen, color, activo, material,
                talla_ropa, tipo_cierre,TipoRopa.PANTALON,tiene_bolsillo, tipo_pantalon);
    }

    public static Pedido crearPedido(Cliente DNI_cliente, MetodoPago m_pago) {
        System.out.println("\n--- Nuevo Pedido ---");
         int numero = ConsoleReader.readInt("Introduce el numero de pedido");
         Date fecha = ConsoleReader.readDate("Introduce la fecha en format DD-MM-YYYY");
         String dir_envio = ConsoleReader.readString("Introduce la direccion de envio:");



        return new Pedido(numero,fecha,EstadoPedido.EN_PROCESO,dir_envio,DNI_cliente);
    }


}