package TP3;
import java.util.*;
import java.util.stream.*;

// Le cambiamos el nombre para que no choque con otras clases "Persona"
class PersonaTP3 {
    private int dni;
    private String nombre;

    PersonaTP3(int dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public int getDni() { return dni; }
    public String getNombre() { return nombre; }
}

public class Ejercicio4 {
    public static void ejecutar() {
        // 4.2 Optional y findFirst
        Optional<Integer> par = Stream.of(1, 3, 6, 8).filter(n -> n % 2 == 0).findFirst();
        par.ifPresent(n -> System.out.println("Primer par hallado: " + n));

        // 4.4 Collectors a Mapa - Usando el nombre nuevo PersonaTP3
        List<PersonaTP3> lista = Arrays.asList(
            new PersonaTP3(1, "Elena"), 
            new PersonaTP3(2, "Roberto")
        );
        
        Map<Integer, String> mapa = lista.stream()
                .collect(Collectors.toMap(PersonaTP3::getDni, PersonaTP3::getNombre));
        
        System.out.println("Mapa generado: " + mapa);
    }
}