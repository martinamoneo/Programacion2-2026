package TP3;
import java.util.*;
import java.util.function.*;

// ej 1.1, 1.2 y 1.3

public class EjercicioLambdas {
    public static void ejecutar() {
        // 1.1 y 1.3 Interfaces funcionales y variantes primitivas
        IntPredicate esPar = n -> n % 2 == 0;
        ToIntFunction<String> longitud = s -> s.length();
        Consumer<Integer> imprimir = n -> System.out.println("Numero: " + n);
        Supplier<Double> aleatorio = () -> Math.random();

        System.out.println("Es 10 par?: " + esPar.test(10));
        imprimir.accept(longitud.applyAsInt("Java"));

        // 1.2 Ordenación por longitud
        List<String> palabras = Arrays.asList("Back", "Git", "Front");
        palabras.sort((a, b) -> a.length() - b.length());
        System.out.println("Ordenadas: " + palabras);
    }
}
