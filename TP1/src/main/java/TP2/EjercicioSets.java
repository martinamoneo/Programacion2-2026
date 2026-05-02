package TP2;
import java.util.*;

public class EjercicioSets {
    public static void main(String[] args) {
        // 3.1 Unicidad en Sets (No permite duplicados)
        Set<Integer> conjunto = new HashSet<>();
        
        conjunto.add(10);
        conjunto.add(10); // Intentamos meter el mismo número 3 veces
        conjunto.add(10);
        
        // Verificamos el tamaño (debería ser 1)
        System.out.println("Tamaño del set (debería ser 1): " + conjunto.size());
        
        // Comprobar si existe y eliminar
        if(conjunto.contains(10)) {
            conjunto.remove(10);
        }
        System.out.println("Set después de borrar: " + conjunto);
    }
}
