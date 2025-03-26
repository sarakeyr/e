package com.iescamp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
    private static final String CATALOGO_BIN_FILE = "catalogo.dat";
    private static final String VENTAS_BIN_FILE = "ventas.dat";
    private static final String CLIENTELA_BIN_FILE = "clientela.dat";
    private static final String PLANTILLA_BIN_FILE = "plantilla.dat";
    private static final String CATALOGO_JSON_FILE = "catalogo.json";
    private static final String VENTAS_JSON_FILE = "ventas.json";
    private static final String CLIENTELA_JSON_FILE = "clientela.json";
    private static final String PLANTILLA_JSON_FILE = "plantilla.json";

    // Métodos de serialización binaria
    public static void serializarObjeto(Object objeto, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(objeto);
            System.out.println("Objeto serializado: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al serializar objeto: " + filePath);
            e.printStackTrace();
        }
    }

    public static <T> T deserializarObjeto(String filePath, Class<T> clase) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            T objeto = clase.cast(ois.readObject());
            System.out.println("Objeto deserializado: " + filePath);
            return objeto;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar objeto: " + filePath);
            e.printStackTrace();
            return null;
        }
    }

    // Métodos de serialización JSON
    public static void guardarEnJson(Object objeto, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            mapper.writeValue(new File(filePath), objeto);
            System.out.println("Archivo JSON creado: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo JSON: " + filePath);
            e.printStackTrace();
        }
    }

    public static <T> T leerDesdeJson(String filePath, Class<T> clase) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            T objeto = mapper.readValue(new File(filePath), clase);
            System.out.println("Archivo JSON leído: " + filePath);
            return objeto;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo JSON: " + filePath);
            e.printStackTrace();
            return null;
        }
    }

    // Métodos para gestionar CSV
    public static void guardarClientesEnCsv(List<Cliente> clientes, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"DNI", "Nombre", "Apellidos", "Dirección", "Correo Electrónico", "Teléfono", "Fecha Nacimiento", "Contraseña", "Activo", "Dirección Envío", "Saldo Cuenta", "Tarjeta Fidelidad", "Pedidos Realizados", "Código Método Pago", "Descripción Método Pago"});
            for (Cliente c : clientes) {
                writer.writeNext(new String[]{
                        c.getDni(), c.getNombre(), c.getApellidos(), c.getDireccion(), c.getEmail(),
                        c.getTelefono(), c.getF_echanacimiento().toString(), c.getPass(),
                        String.valueOf(c.isActivo()), c.getDir_envio(), String.valueOf(c.getSaldo_cuenta()),
                        String.valueOf(c.isTarjeta_fidelizacion()), String.valueOf(c.getNum_pedidos()),
                        String.valueOf(c.getM_pago().getCodigo()), c.getM_pago().getDescripcion()
                });
            }
        }
    }

    public static List<Cliente> leerClientesDesdeCsv(String filePath) throws IOException, CsvException {
        List<Cliente> clientes = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> datos = reader.readAll();
            datos.remove(0); // Eliminar encabezado
            for (String[] fila : datos) {
                Cliente cliente = new Cliente(
                        fila[0], fila[1], fila[2], fila[3], fila[4], fila[5],
                        LocalDate.parse(fila[6]), fila[7], Boolean.parseBoolean(fila[8]),
                        fila[9], Float.parseFloat(fila[10]), Boolean.parseBoolean(fila[11]),
                        Integer.parseInt(fila[12]), new MetodoPago(Integer.parseInt(fila[13]), fila[14])
                );
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public static void guardarEmpleadosEnCsv(List<Empleado> empleados, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"DNI", "Nombre", "Apellidos", "Dirección", "Correo Electrónico", "Teléfono", "Fecha Nacimiento", "Contraseña", "Activo", "Privilegios", "Departamento"});
            for (Empleado e : empleados) {
                writer.writeNext(new String[]{
                        e.getDni(), e.getNombre(), e.getApellidos(), e.getDireccion(), e.getEmail(),
                        e.getTelefono(), e.getF_echanacimiento().toString(), e.getPass(),
                        String.valueOf(e.isActivo()), String.valueOf(e.isTienePrivilegios()),
                        e.getDepartamento().getNombre()
                });
            }
        }
    }

    public static List<Empleado> leerEmpleadosDesdeCsv(String filePath) throws IOException, CsvException {
        List<Empleado> empleados = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> datos = reader.readAll();
            datos.remove(0); // Eliminar encabezado
            for (String[] fila : datos) {
                Empleado empleado = new Empleado(
                        fila[0], fila[1], fila[2], fila[3], fila[4], fila[5],
                        LocalDate.parse(fila[6]), fila[7], Boolean.parseBoolean(fila[8]),
                        Boolean.parseBoolean(fila[9]), new Departamento(0, fila[10])
                );
                empleados.add(empleado);
            }
        }
        return empleados;
    }

    public static void guardarArticulosEnCsv(List<Articulo> articulos, String filePath) throws IOException {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"Tipo", "Código", "Nombre", "Descripción", "Marca", "Precio", "Color", "Imagen", "Activo", "Código Material", "Denominación Material", "Atributos Específicos"});
            for (Articulo a : articulos) {
                String tipo = a.getClass().getSimpleName();
                String[] commonFields = new String[]{
                        tipo, String.valueOf(a.getCod_art()), a.getNombre(), a.getDescripcion(),
                        a.getMarca(), String.valueOf(a.getPrecio()), a.getColor(),
                        a.getImagen(), String.valueOf(a.isActivo()),
                        String.valueOf(a.getMaterial().getCodigo()), a.getMaterial().getDenominacion()
                };
                String[] specificFields;
                switch (tipo) {
                    case "Camisa":
                        Camisa camisa = (Camisa) a;
                        specificFields = new String[]{camisa.getTipo_manga(), String.valueOf(camisa.isEstampada())};
                        break;
                    case "Zapatos":
                        Zapato zapatos = (Zapato) a;
                        specificFields = new String[]{String.valueOf(zapatos.getTalla_zapatos()), zapatos.getTipo_suela()};
                        break;
                    case "Chaqueta":
                        Chaqueta chaqueta = (Chaqueta) a;
                        specificFields = new String[]{chaqueta.getTalla_ropa(), chaqueta.getTipo_cierre(), String.valueOf(chaqueta.isImpermeable())};
                        break;
                    case "Pantalon":
                        Pantalon pantalon = (Pantalon) a;
                        specificFields = new String[]{pantalon.getTalla_ropa(), pantalon.getTipo_cierre(), String.valueOf(pantalon.isTiene_bolsillo()), pantalon.getTipo_pantalon()};
                        break;
                    case "Bolso":
                        Bolso bolso = (Bolso) a;
                        specificFields = new String[]{bolso.getEstilo(), String.valueOf(bolso.isPersonalizado()), bolso.getCierre_bolso(), String.valueOf(bolso.getCapacidad())};
                        break;
                    default:
                        specificFields = new String[]{};
                        break;
                }
                writer.writeNext(concatenateArrays(commonFields, specificFields));
            }
        }
    }

    private static String[] concatenateArrays(String[] first, String[] second) {
        String[] result = new String[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static List<Articulo> leerArticulosDesdeCsv(String filePath) throws IOException, CsvException {
        List<Articulo> articulos = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            List<String[]> datos = reader.readAll();
            datos.remove(0); // Eliminar encabezado
            for (String[] fila : datos) {
                String tipo = fila[0];
                Material material = new Material(Integer.parseInt(fila[9]), fila[10]);
                int cod_art = Integer.parseInt(fila[1]);
                boolean activo = Boolean.parseBoolean(fila[8]);
                String color = fila[6];
                String imagen = fila[7];
                String nombre = fila[2];
                double precio = Double.parseDouble(fila[5]);
                String marca = fila[4];
                String descripcion = fila[3];

                Articulo articulo = null;
                switch (tipo) {
                    case "Camisa":
                        articulo = new Camisa(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, fila[11], fila[12], fila[13], Boolean.parseBoolean(fila[14]));
                        break;
                    case "Zapatos":
                        articulo = new Zapato(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, fila[11], Boolean.parseBoolean(fila[12]), Integer.parseInt(fila[13]), fila[14]);
                        break;
                    case "Chaqueta":
                        articulo = new Chaqueta(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, fila[11], fila[12], Boolean.parseBoolean(fila[13]));
                        break;
                    case "Pantalon":
                        articulo = new Pantalon(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, fila[11], fila[12], Boolean.parseBoolean(fila[13]), fila[14]);
                        break;
                    case "Bolso":
                        articulo = new Bolso(material, cod_art, activo, color, imagen, nombre, precio, marca, descripcion, fila[11], Boolean.parseBoolean(fila[12]), fila[13], fila[14]);
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo de artículo desconocido: " + tipo);
                }
                articulos.add(articulo);
            }
        }
        return articulos;
    }
}