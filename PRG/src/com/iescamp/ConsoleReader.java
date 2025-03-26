package com.iescamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class ConsoleReader {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));



    public static int readInt() {
        while (true) {
            try {
                return Integer.parseInt(reader.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }

    public static int readInt(String msg) {
        System.out.println(msg);
        return readInt();

    }

    public static int readInt(int inicio, int fin) {
        while (true) {
            int a = readInt();
            if (a>=inicio && a <=fin)
                return a;
            else
                System.out.println("Entrada no válida. Intenta de nuevo.");
        }
    }

    public static int readInt(String msg, int inicio, int fin) {
        System.out.println(msg);
        return readInt(inicio, fin);

    }

    public static double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(reader.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }
    public static double readDouble(String msg){
        System.out.println(msg);
        return(readDouble());

    }

    public static float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(reader.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Entrada no válida. Intenta de nuevo.");
            }
        }
    }
    public static float readFloat(String msg){
        System.out.println(msg);
        return(readFloat());

    }


    public static boolean readBoolean() {
        while (true) {
            String cadena = readString();
            if ("true".equals(cadena)) {
                return true;
            } else if ("false".equals(cadena)) {
                return false;
            } else {
                System.out.println("Entrada no válida. Por favor, introduce solo 'true' o 'false'.");
            }
        }
    }
    public static boolean readBoolean(String msg){
        System.out.println(msg);
        return(readBoolean());

    }

    public static String readString() {
        while (true) {
            try {
                return reader.readLine().trim();
            } catch (IOException e) {
                System.out.println("Error de lectura. Intenta de nuevo.");
            }
        }
    }

    public static String readString(String msg){
        System.out.println(msg);
        return readString();
    }

    public static Date readDate(String dateFormat) {
        while (true) {
            try {
                String dateString = reader.readLine().trim();
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                sdf.setLenient(false); // Para evitar fechas inválidas como 31/02
                return sdf.parse(dateString);
            } catch (IOException | ParseException e) {
                System.out.println("Entrada no válida. El formato esperado es: " + dateFormat);
            }
        }
    }

    public static Date readDate(String msg, String dateFormat) {
        System.out.println(msg);
        return readDate(dateFormat);
    }

    public static LocalDate readLocalDate(String dateFormat) {
        while (true) {
            try {
                String dateString = reader.readLine().trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
                return LocalDate.parse(dateString, formatter);
            } catch (IOException | DateTimeParseException e) {
                System.out.println("Entrada no válida. El formato esperado es: " + dateFormat);
            }
        }
    }

    public static LocalDate readLocalDate(String msg, String dateFormat) {
        System.out.println(msg);
        return readLocalDate(dateFormat);
    }
}