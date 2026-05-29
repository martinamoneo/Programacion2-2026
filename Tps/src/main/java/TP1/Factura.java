package TP1;

// Hereda de Documento e implementa las dos interfaces
public class Factura extends Documento implements Exportable, Auditable {
    
    private String nroFactura;

    public Factura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    // Ejercicio 3.2: Sobrescribimos el método del padre
    @Override
    public void procesar() {
        System.out.println("Procesando factura nro: " + nroFactura);
    }

    // Ejercicio 3.3: Sobrecarga (mismo nombre, pero con un booleano)
    public void procesar(boolean esUrgente) {
        if (esUrgente) {
            System.out.println("ALERTA: Procesando factura URGENTE.");
        } else {
            procesar(); // Llama al método de arriba
        }
    }

    // Ejercicio 4.1: Implementación obligatoria de las interfaces
    @Override
    public void exportar() {
        System.out.println("Exportando factura a PDF...");
    }

    @Override
    public void registrarAuditoria() {
        System.out.println("Auditoría: Factura " + nroFactura + " registrada correctamente.");
    }
}
