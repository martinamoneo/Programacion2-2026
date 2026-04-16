package martina.tp1.programacion2;

public class Main {

public static void main(String[] args) {
    
    // Probar SistemaGestor
    SistemaGestor sg = new SistemaGestor(); // se crea la variable sg que recive valores SistemaGestor y despues se crea el objeto
    sg.mostrarConfiguracion(); // la variable ejecuta mostrarConfiguracion

    // Probar CuentaBancaria
    CuentaBancaria cuenta = new CuentaBancaria("123-ABC", 1000); // se crea una nva cuenta con el nro de cuenta 123-ABC y mil pesos
    cuenta.depositar(-50); // deberia dar error
    cuenta.depositar(500); // deberia funcionar

    // Probar Reporte
    Reporte rep = new Reporte(); // se crea un nuevo reporte y se guarda en rep
    rep.imprimirSecciones("Introducción", "Datos", "Final"); // le pasas valores para que muestre
    rep.imprimirSecciones(); // no le pasa nada y deberia funcionar igual
}
}
