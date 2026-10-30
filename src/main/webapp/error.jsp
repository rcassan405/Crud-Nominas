<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error en la Aplicación</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="container">
        <h2>Ocurrió un Error</h2>
        <div class="alert-error">
            <%= request.getAttribute("mensajeError") != null ? request.getAttribute("mensajeError") : "Ha ocurrido un error inesperado." %>
        </div>
        <a href="javascript:history.back()" class="btn btn-back">Volver</a>
    </div>
</body>
</html>