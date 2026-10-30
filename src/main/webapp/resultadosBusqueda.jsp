<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, model.Empleado" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultados de la Búsqueda</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Registros Encontrados</h2>
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
                    List<Empleado> resultados = (List<Empleado>) request.getAttribute("resultados");
                    if (resultados != null && !resultados.isEmpty()) {
                        for (Empleado emp : resultados) {
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
                    <td colspan="5">No se encontraron empleados con los criterios especificados.</td>
                </tr>
                <% } %>
            </tbody>
        </table>
        <br>
        <a href="javascript:history.back()" class="btn btn-back">Volver</a>
    </div>
</body>
</html>