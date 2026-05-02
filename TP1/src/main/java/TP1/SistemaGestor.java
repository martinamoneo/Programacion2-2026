package TP1;

/**
 * Clase SistemaGestor: Se encarga de la configuración básica del sistema (reglas y cosas que no cambian).
 */
public class SistemaGestor {

    public static final int MAX_CONEXIONES = 10; // static hace que pertenezca a toda la clase y final hace q no se pueda cambiar

    public void mostrarConfiguracion() {
        int tiempoEspera = 30; // variable local 
        
        System.out.println("Máximo de conexiones permitidas: " + MAX_CONEXIONES); // muestra la cant de conexiones permitidas
    }
}
