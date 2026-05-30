package TP7;

public class Empleado {
    private int id;
    private String nombre;
    private int idDepto; // int para la clave foranea
    private String rutaFoto; // variable para foto

    public Empleado() {}

    public Empleado(int id, String nombre, int idDepto, String rutaFoto) {
        this.id = id;
        this.nombre = nombre;
        this.idDepto = idDepto;
        this.rutaFoto = rutaFoto;
    }

    // getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getIdDepto() { return idDepto; }
    public void setIdDepto(int idDepto) { this.id = idDepto; }

    public String getRutaFoto() { return rutaFoto; }
    public void setRutaFoto(String rutaFoto) { this.rutaFoto = rutaFoto; }
}
