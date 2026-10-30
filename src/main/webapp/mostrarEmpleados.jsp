<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Empleado" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Empleados</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Listado de Empleados</h2>
        <table>
            <thead>
                <tr>
                    <th>DNI</th>
                    <th>Nombre</th>
                    <th>Sexo</th>
                    <th>Categoría</th>
                    <th>Años Trabajados</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Empleado> empleados = (List<Empleado>) request.getAttribute("empleados");
                    if (empleados != null && !empleados.isEmpty()) {
                        for (Empleado emp : empleados) {
                %>
                <tr>
                    <td><%= emp.getDni() %></td>
                    <td><%= emp.getNombre() %></td>
                    <td><%= emp.getSexo() %></td>
                    <td><%= emp.getCategoria() %></td>
                    <td><%= emp.getAnyos() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5">No existen empleados registrados.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <br>
        <a href="javascript:history.back()" class="btn btn-back">Volver</a>
    </div>
</body>
</html>