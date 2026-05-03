package TP4;

public class MainTP4 {
    public static void main(String[] args) {
        System.out.println("--- Ejercicio 1.1: NumberFormatException ---");
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Mensaje: " + e.getMessage());
            System.out.println("Tipo: " + e.getClass().getName());
        }

        System.out.println("\n--- Ejercicio 1.2: Finally ---");
        EjerciciosBase.simularDivision();

        System.out.println("\n--- Ejercicio 2.2: Captura Específica ---");
        try {
            EjerciciosBase.registrarUsuario("Matias", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }

        System.out.println("\n--- Ejercicio 3.1: Checked (Saldo) ---");
        try {
            double saldo = 100;
            double retiro = 150;
            if (retiro > saldo) throw new SaldoInsuficienteException("No tenés plata.");
        } catch (SaldoInsuficienteException e) {
            System.out.println("Tratamiento obligatorio: " + e.getMessage());
        }

        System.out.println("\n--- Ejercicio 3.2: Unchecked (Producto) ---");
        // Si ponés un precio de -10, el programa falla si no hacés try-catch
        System.out.println("Instanciando producto con precio inválido...");
        // throw new ProductoInvalidoException("Precio menor a cero"); 
        
        System.out.println("\n--- Ejercicio 4.1: Archivos ---");
        ManejoArchivos.leerArchivo();
    }
}
