package martina.tp1.programacion2;

public class Usuario {
    // atibutos privados
    private String nombre;
    private int edad;

    /* La sobrecarga es que depende la info que se reciba es el constructor o metodo q
        se usa para guardarla*/
    
    // Sobrecarga de Constructores
    public Usuario() { } // constructor vacio, guarda el espacio pero no tiene nada adentro

    public Usuario(String nombre) {
        this.nombre = nombre; // constructor guarda el nombre
    }

    public Usuario(String nombre, int edad) { // el constructor guarda toda la info
        this.nombre = nombre;
        this.edad = edad;
    }

    // Sobrecarga de Métodos
    public void actualizarPerfil(String correo) {
        System.out.println("Correo actualizado a: " + correo); // pide el correo
    }

    public void actualizarPerfil(String correo, int telefono) {
        System.out.println("Correo: " + correo + " | Teléfono: " + telefono); // pide el correo y el telefono
    }
}
