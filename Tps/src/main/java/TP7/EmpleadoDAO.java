package TP7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements OperacionesDAO {

    @Override
    public void insertar(Empleado empleado) {
        // recibe id depto y ruta foto
        String sql = "INSERT INTO empleados (nombre, id_depto, ruta_foto) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, empleado.getNombre());
            pstmt.setInt(2, empleado.getIdDepto());
            pstmt.setString(3, empleado.getRutaFoto()); // enviar ruta de archivo
            pstmt.executeUpdate();
            System.out.println("DAO: Empleado '" + empleado.getNombre() + "' insertado con éxito.");
            
        } catch (SQLException e) {
            System.out.println("DAO: Error al insertar: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Empleado empleado) {
        
        String sql = "UPDATE empleados SET nombre = ?, id_depto = ?, ruta_foto = ? WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, empleado.getNombre());
            pstmt.setInt(2, empleado.getIdDepto());
            pstmt.setString(3, empleado.getRutaFoto());
            pstmt.setInt(4, empleado.getId());
            
            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("DAO: Empleado con ID " + empleado.getId() + " actualizado.");
            }
        } catch (SQLException e) {
            System.out.println("DAO: Error al actualizar: " + e.getMessage());
        }
    }

    @Override
    public void borrar(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            int filas = pstmt.executeUpdate();
            if (filas > 0) {
                System.out.println("DAO: Empleado con ID " + id + " borrado.");
            }
        } catch (SQLException e) {
            System.out.println("DAO: Error al borrar: " + e.getMessage());
        }
    }

    @Override
    public List<Empleado> consultarTodos() {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setId(rs.getInt("id"));
                emp.setNombre(rs.getString("nombre"));
                emp.setIdDepto(rs.getInt("id_depto")); 
                emp.setRutaFoto(rs.getString("ruta_foto")); // lee la ruta de la foto
                lista.add(emp);
            }
            
        } catch (SQLException e) {
            System.out.println("DAO: Error al consultar todos: " + e.getMessage());
        }
        
        return lista;
    }
}
