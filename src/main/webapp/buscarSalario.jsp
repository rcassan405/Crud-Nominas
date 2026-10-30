<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Buscar Salario</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Consultar Salario de Empleado</h2>
        <form action="consultarSalario" method="get">
            <div class="form-group">
                <label for="dni">DNI del Empleado:</label>
                <input type="text" id="dni" name="dni" required placeholder="Ej: 12345678A">
            </div>
            <button type="submit" class="btn">Consultar Salario</button>
        </form>
        <br>
        <a href="javascript:history.back()" class="btn btn-back">Volver</a>
    </div>
</body>
</html>