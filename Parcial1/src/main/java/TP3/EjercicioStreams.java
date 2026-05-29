package TP3;
import java.util.*;
import java.util.stream.*;

// ej desde 2.1 a 3.4

public class EjercicioStreams {
    public static void ejecutar() {
        // 2.1 y 2.2 Filtrado
        System.out.println("Conteo de elementos: " + 
            Stream.of(2, 5, 3, 3, 6, 2, 4).distinct().skip(1).limit(3).count());

        // 3.1 y 3.2 Transformación
        List<String> nombres = Arrays.asList("Juan", "Maria", "Ana");
        int suma = nombres.stream().map(String::toUpperCase).mapToInt(String::length).sum();
        System.out.println("Suma de letras: " + suma);

        // 3.3 FlatMap
        List<List<String>> grupos = Arrays.asList(Arrays.asList("Ana", "Luis"), Arrays.asList("Lucia"));
        long masDe4 = grupos.stream().flatMap(List::stream).filter(n -> n.length() > 4).count();
        System.out.println("Nombres largos: " + masDe4);
    }
}
