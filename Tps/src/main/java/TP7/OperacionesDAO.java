package TP7;

import java.util.List;

public interface OperacionesDAO {
    void insertar(Empleado empleado);
    void actualizar(Empleado empleado);
    void borrar(int id);
    List<Empleado> consultarTodos();
}
