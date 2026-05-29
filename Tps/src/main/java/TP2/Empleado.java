package TP2;

public class Empleado implements Comparable<Empleado> {
    private String nombre;
    private int edad;

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters para poder leer los datos
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    // 5.1 Orden natural: Por edad
    @Override
    public int compareTo(Empleado otro) {
        return Integer.compare(this.edad, otro.edad);
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ")";
    }
}
