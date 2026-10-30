import dao.EmpleadoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/consultarSalario")
public class SalarioServlet extends HttpServlet {

    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String dni = request.getParameter("dni");

        if (dni == null || dni.trim().isEmpty()) {
            request.setAttribute("mensajeError", "Debe proporcionar un DNI válido.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        try {
            Double salario = empleadoDAO.obtenerSalarioPorDni(dni.trim());
            
            if (salario != null) {
                request.setAttribute("dni", dni.trim());
                request.setAttribute("salario", salario);
                // Asegúrate de que la ruta comience por '/'
                request.getRequestDispatcher("/mostrarSalario.jsp").forward(request, response);
            } else {
                request.setAttribute("mensajeError", "No se encontró ningún empleado registrado con el DNI: " + dni);
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("mensajeError", "Error al consultar el salario: " + e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}