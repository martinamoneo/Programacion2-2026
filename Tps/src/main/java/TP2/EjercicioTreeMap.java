package TP2;
import java.util.*;

public class EjercicioTreeMap {
    public static void main(String[] args) {
        // Usamos TreeMap para que los IDs salgan en orden
        TreeMap<Integer, String> mapaOrdenado = new TreeMap<>();
        
        mapaOrdenado.put(500, "Sofia");
        mapaOrdenado.put(100, "Matias");
        mapaOrdenado.put(300, "Gabriel");

        System.out.println("Usuarios ordenados por ID:");
        for (Integer id : mapaOrdenado.keySet()) {
            System.out.println("ID: " + id + " | Nombre: " + mapaOrdenado.get(id));
        }
    }
}
