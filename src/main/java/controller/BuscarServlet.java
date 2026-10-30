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
 * Controlador para la búsqueda avanzada de empleados según múltiples criterios.
 */
@WebServlet("/buscarEmpleados")
public class BuscarServlet extends HttpServlet {
    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String dni = request.getParameter("dni");
        String nombre = request.getParameter("nombre");
        String sexo = request.getParameter("sexo");
        String catStr = request.getParameter("categoria");
        String anyosStr = request.getParameter("anyos");

        Integer categoria = (catStr != null && !catStr.trim().isEmpty()) ? Integer.parseInt(catStr) : null;
        Integer anyos = (anyosStr != null && !anyosStr.trim().isEmpty()) ? Integer.parseInt(anyosStr) : null;

        try {
            List<Empleado> resultados = empleadoDAO.buscarEmpleados(dni, nombre, sexo, categoria, anyos);
            request.setAttribute("resultados", resultados);
            request.getRequestDispatcher("/resultadosBusqueda.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensajeError", "Error durante la búsqueda de empleados: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
