package TP1;

public class Reporte {

    // no devuelve nada (void) solo muestra el msj
    public void generarEncabezado() {
        System.out.println("=== REPORTE DEL SISTEMA ===");
    }

    // te devuelve un string
    public String obtenerCuerpo() {
        return "Este es el contenido detallado del reporte generado.";
    }

    // metodo para mostrar las secciones sin importar la cantidad q sean
    public void imprimirSecciones(String... secciones) {
        System.out.println("Secciones del reporte:");
        // El bucle for-each recorre todas las secciones y les pone un guion adelante
        for (String s : secciones) {
            System.out.println("- " + s);
        }
    }
}
