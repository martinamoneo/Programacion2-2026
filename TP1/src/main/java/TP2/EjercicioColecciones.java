package TP2;
import java.util.*;

public class EjercicioColecciones {
    public static void main(String[] args) {
        
        // --- 3.2 ArrayDeque (Cola de doble extremo) ---
        ArrayDeque<String> cola = new ArrayDeque<>();
        cola.addFirst("Primero"); // Agrega al inicio
        cola.addLast("Último");   // Agrega al final
        
        System.out.println("Extremos recuperados: " + cola.peekFirst() + " y " + cola.peekLast());
        
        cola.removeFirst(); // Borra el primero
        cola.removeLast();  // Borra el último
        System.out.println("Cola despues de limpiar extremos: " + cola);

        System.out.println("-----------------------------------");

        // --- 4.1 HashMap (Usuarios: ID -> Nombre) ---
        // El Integer es el ID y el String es el Nombre
        HashMap<Integer, String> usuarios = new HashMap<>();
        
        usuarios.put(101, "Nare"); // Usamos put() para agregar
        usuarios.put(102, "Martina");
        usuarios.put(103, "Sofii");
        
        // Recuperar y actualizar
        String nombre = usuarios.get(102); // Debería traerte "Martina"
        usuarios.replace(101, "Nare B."); // Actualiza el nombre
        
        usuarios.remove(103); // Elimina a Sofii por su clave
        
        System.out.println("Lista de usuarios actual: " + usuarios);
    }
}
