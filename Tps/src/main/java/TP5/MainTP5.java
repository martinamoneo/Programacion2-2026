package TP5;

public class MainTP5 {
    public static void main(String[] args) throws InterruptedException {
        // --- PARTE 1 ---
        System.out.println("--- 1.1 y 1.2: Inicio de Hilos ---");
        TareaHilo h1 = new TareaHilo();
        h1.setName("Hilo-Extends");
        
        Thread h2 = new Thread(new TareaRunnable(), "Hilo-Runnable");
        
        h1.start();
        h2.start();
        h1.join(); h2.join(); // Esperamos para que no se mezcle con lo que sigue

        // --- PARTE 2 y 3 ---
        System.out.println("\n--- 2.1 y 3.1: Condición de Carrera y Sync ---");
        Contador cont = new Contador();
        Runnable tareaContar = () -> {
            for(int i=0; i<10000; i++) cont.incrementarSincronizado();
        };

        Thread t1 = new Thread(tareaContar);
        Thread t2 = new Thread(tareaContar);
        t1.start(); t2.start();
        t1.join(); t2.join();
        System.out.println("Resultado final del contador: " + cont.getCuenta());

        // --- PARTE 4 ---
        System.out.println("\n--- 4.1: Prioridades ---");
        Thread pLow = new Thread(() -> System.out.println("Prioridad 1"), "Baja");
        Thread pHigh = new Thread(() -> System.out.println("Prioridad 10"), "Alta");
        pLow.setPriority(Thread.MIN_PRIORITY); // 1
        pHigh.setPriority(Thread.MAX_PRIORITY); // 10
        pLow.start(); pHigh.start();

        System.out.println("\n--- 4.2: Join e Interrupt ---");
        Thread espera = new Thread(ControlHilos::tareaLarga, "Hilo-Largo");
        espera.start();
        // espera.join(); // Descomentá esto para que el main espere a que termine
        Thread.sleep(1000); 
        espera.interrupt(); // Lo interrumpimos a los 1 segundos
    }
}
