package TP2;
import java.util.Arrays;

public class EjercicioArrays {
    public static void main(String[] args) {
        // Ejercicio 1.1: Creación y actualización
        int[] numeros = new int[5]; // Tamaño fijo de 5
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30; // Este es el tercer elemento (índice 2)
        
        // Actualizamos el tercer elemento
        numeros[2] = 35;
        
        // Recuperamos el último usando .length
        int ultimo = numeros[numeros.length - 1];
        System.out.println("Último elemento: " + ultimo);

        // Ejercicio 1.2: Ordenamiento y Búsqueda
        String[] nombres = {"Martina", "Agustin", "Sofii", "Guadita"};
        Arrays.sort(nombres); // Los ordena alfabéticamente
        
        int posicion = Arrays.binarySearch(nombres, "Martina");
        System.out.println("Martina está en la posición: " + posicion);
    }
}