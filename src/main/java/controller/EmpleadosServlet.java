/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EmpleadoDAO;
import model.Empleado;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Controlador que procesa la solicitud de listado de todos los empleados.
 */
@WebServlet("/mostrarEmpleados")
public class EmpleadosServlet extends HttpServlet {
    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            List<Empleado> empleados = empleadoDAO.obtenerTodos();
            request.setAttribute("empleados", empleados);
            request.getRequestDispatcher("/mostrarEmpleados.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensajeError", "Error al consultar los empleados en la base de datos: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}