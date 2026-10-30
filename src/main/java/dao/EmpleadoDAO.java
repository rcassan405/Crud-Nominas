/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import conexion.Conexion;
import model.Empleado;
/**
 *
 * @author rcass
 */
public class EmpleadoDAO {
    public List<Empleado> obtenerTodos() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT dni, nombre, sexo, categoria, anyos FROM empleados ORDER BY dni ASC";
        
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(new Empleado(
                    rs.getString("dni"),
                    rs.getString("nombre"),
                    rs.getString("sexo").charAt(0),
                    rs.getInt("categoria"),
                    rs.getInt("anyos")
                ));
            }
        }
        return lista;
    }

    /**
     * Consulta el salario neto o bruto calculado de un empleado desde la tabla de nominas.
     * 
     * @param dni DNI del empleado
     * @return Double sueldo o null si no existe
     * @throws SQLException si ocurre un error en la consulta
     */
    public Double obtenerSalarioPorDni(String dni) throws SQLException {
        String sql = "SELECT sueldo FROM nominas WHERE dni = ?";
        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, dni);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("sueldo");
                }
            }
        }
        return null;
    }

    /**
     * Busca empleados aplicando filtros opcionales.
     * 
     * @param dni filtro de DNI (parcial)
     * @param nombre filtro de Nombre (parcial)
     * @param sexo filtro por sexo ('M', 'F' o null/vacío)
     * @param categoria filtro por categoría (o null)
     * @param anyos filtro por años trabajados (o null)
     * @return List de empleados coincidentes
     * @throws SQLException si falla la consulta SQL
     */
    public List<Empleado> buscarEmpleados(String dni, String nombre, String sexo, Integer categoria, Integer anyos) throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT dni, nombre, sexo, categoria, anyos FROM empleados WHERE 1=1");

        if (dni != null && !dni.trim().isEmpty()) sql.append(" AND dni LIKE ?");
        if (nombre != null && !nombre.trim().isEmpty()) sql.append(" AND nombre LIKE ?");
        if (sexo != null && !sexo.trim().isEmpty()) sql.append(" AND sexo = ?");
        if (categoria != null) sql.append(" AND categoria = ?");
        if (anyos != null) sql.append(" AND anyos = ?");

        sql.append(" ORDER BY dni ASC");

        try (Connection conn = Conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            int paramIndex = 1;
            if (dni != null && !dni.trim().isEmpty()) ps.setString(paramIndex++, "%" + dni.trim() + "%");
            if (nombre != null && !nombre.trim().isEmpty()) ps.setString(paramIndex++, "%" + nombre.trim() + "%");
            if (sexo != null && !sexo.trim().isEmpty()) ps.setString(paramIndex++, sexo.trim());
            if (categoria != null) ps.setInt(paramIndex++, categoria);
            if (anyos != null) ps.setInt(paramIndex++, anyos);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Empleado(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("sexo").charAt(0),
                        rs.getInt("categoria"),
                        rs.getInt("anyos")
                    ));
                }
            }
        }
        return lista;
    }
}
