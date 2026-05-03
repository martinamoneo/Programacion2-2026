package TP2;
import java.util.*;

public class PruebaOrden {
    public static void main(String[] args) {
        List<Empleado> staff = new ArrayList<>();
        staff.add(new Empleado("Ana", 21));
        staff.add(new Empleado("Juan", 24));
        staff.add(new Empleado("Matias", 20));

        // Orden natural (por edad, gracias al compareTo)
        Collections.sort(staff);
        System.out.println("Orden por edad: " + staff);

        // 5.2 Orden personalizado: Por nombre (usando un Comparator)
        staff.sort((e1, e2) -> e1.getNombre().compareTo(e2.getNombre()));
        System.out.println("Orden alfabético: " + staff);
    }
}