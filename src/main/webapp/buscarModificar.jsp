<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Búsqueda de Empleados</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Búsqueda de Empleados para Modificación</h2>
        <form action="buscarEmpleados" method="get">
            <div class="form-group">
                <label for="dni">DNI:</label>
                <input type="text" id="dni" name="dni">
            </div>
            <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre">
            </div>
            <div class="form-group">
                <label for="sexo">Sexo:</label>
                <select id="sexo" name="sexo">
                    <option value="">-- Todos --</option>
                    <option value="M">Masculino (M)</option>
                    <option value="F">Femenino (F)</option>
                </select>
            </div>
            <div class="form-group">
                <label for="categoria">Categoría:</label>
                <input type="number" id="categoria" name="categoria" min="1" max="10">
            </div>
            <div class="form-group">
                <label for="anyos">Años trabajados:</label>
                <input type="number" id="anyos" name="anyos" min="0">
            </div>
            <button type="submit" class="btn">Buscar</button>
        </form>
        <br>
        <a href="javascript:history.back()" class="btn btn-back">Volver</a>
    </div>
</body>
</html>