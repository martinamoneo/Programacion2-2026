package TP5;

class Contador {
    private int cuenta = 0;

    // 3.1 Método sincronizado (bloquea el objeto entero)
    public synchronized void incrementarSincronizado() {
        cuenta++;
    }

    // 3.2 Bloque sincronizado (más específico)
    public void incrementarConBloque() {
        synchronized(this) {
            cuenta++;
        }
    }
    
    public void incrementarNormal() { cuenta++; }
    public int getCuenta() { return cuenta; }
}
