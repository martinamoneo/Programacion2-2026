package TP4;
import java.util.*;

public class EjerciciosBase {
    
    // 1.1 y 1.3 Bloques Try-Catch y Multi-catch
    public static void probarConversiones(String valor) {
        try {
            int numero = Integer.parseInt(valor);
            int resultado = 100 / numero;
            System.out.println("Resultado: " + resultado);
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Error de cálculo o conversión.");
        }
    }

    // 1.2 Bloque Finally
    public static void simularDivision() {
        try {
            int division = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("Limpieza final");
        }
    }

    // 2.1 y 2.2 Validar y Fallar Rápido
    public static void registrarUsuario(String nombre, int edad) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa.");
        }
        System.out.println("Usuario registrado: " + nombre);
    }
}