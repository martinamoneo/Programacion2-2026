package TP4;
import java.io.*;

public class ManejoArchivos {
    public static void leerArchivo() {
        // El try con paréntesis cierra el archivo solo al terminar
        try (BufferedReader br = new BufferedReader(new FileReader("personas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudo procesar el archivo: " + e.getMessage());
        }
    }
}
