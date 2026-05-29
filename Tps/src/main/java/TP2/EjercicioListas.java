package TP2;
import java.util.*;

public class EjercicioListas {
    public static void main(String[] args) {
        
        // --- Ejercicio 2.1: Operaciones CRUD en ArrayList ---
        // El ArrayList es como una lista que se ajusta sola
        List<String> listaDinamica = new ArrayList<>();
        
        listaDinamica.add("Java");      // Agregamos elementos
        listaDinamica.add("Express");
        listaDinamica.add("CSS");
        
        listaDinamica.set(1, "JavaScript"); // Actualiza el segundo (índice 1)
        
        System.out.println("Primer elemento: " + listaDinamica.get(0));
        
        listaDinamica.remove(listaDinamica.size() - 1); // Elimina el último
        System.out.println("Lista después de borrar el último: " + listaDinamica);

        System.out.println("-----------------------------------");

        // --- Ejercicio 2.2: Listas Inmutables vs LinkedList ---
        
        // Creamos una lista que NO se puede tocar (inmutable)
        List<String> fija = List.of("A", "B", "C");
        
        try {
            System.out.println("Intentando agregar a una lista inmutable...");
            fija.add("D"); // Esto va a fallar y disparar el catch
        } catch (UnsupportedOperationException e) {
            System.out.println("¡Error capturado! Como es inmutable, no permite cambios.");
        }

        // Ahora la pasamos a una LinkedList para que sea flexible
        LinkedList<String> mutable = new LinkedList<>(fija);
        
        // Insertamos en el medio (índice 1)
        mutable.add(1, "Elemento Nuevo");
        
        System.out.println("LinkedList final (con inserción en el medio): " + mutable);
    }
}
