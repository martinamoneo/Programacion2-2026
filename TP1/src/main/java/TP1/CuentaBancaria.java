package TP1;

public class CuentaBancaria {
    // variables privadas nadie puede modificarlas
    private double saldo; // double permite decimales
    private String numeroCuenta;

    public CuentaBancaria(String numeroCuenta, double saldoInicial) { // constructor que crea la cuenta con la info q recibe
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    // Método que valida para que no se acepten valores negativos
    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("Error: No se pueden depositar montos negativos.");
        }
    }

    // el getter consulta el saldo ya que es un dato privado
    public double getSaldo() {
        return saldo;
    }
}
