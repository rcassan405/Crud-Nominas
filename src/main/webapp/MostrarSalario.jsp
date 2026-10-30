<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Resultado del Salario</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Información Salarial</h2>
        <p><strong>DNI del Empleado:</strong> <%= request.getAttribute("dni") %></p>
        <p><strong>Salario Calculado:</strong> <%= String.format("%.2f", (Double) request.getAttribute("salario")) %> €</p>
        <br>
        <a href="javascript:history.back()" class="btn btn-back">Volver</a>
    </div>
</body>
</html>