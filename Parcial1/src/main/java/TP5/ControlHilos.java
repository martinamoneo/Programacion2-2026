package TP5;

public class ControlHilos {
    public static void tareaLarga() {
        try {
            System.out.println(Thread.currentThread().getName() + " iniciando tarea larga...");
            Thread.sleep(3000); // Duerme 3 segundos
            System.out.println(Thread.currentThread().getName() + " terminó.");
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido");
        }
    }
}