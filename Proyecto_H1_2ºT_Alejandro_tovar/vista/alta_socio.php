<?php 
require_once '../controlador/SociosController.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $controller = new SociosController();
    // Ahora estamos usando el método `agregarSocio` para agregar un nuevo socio
    $controller->agregarSocio(   
        $id = $_POST['id'],        // ID del socio
        $_POST['nombre'], 
        $_POST['apellidos'], 
        $_POST['correo_email'], 
        $edad = $_POST['edad']       
    );
    // Si el usuario es mayor o igual a 18, redirigimos al formulario de mayores de edad
    if ($edad >= 18) {
        header("Location: alta_socio2.php?id=" . urlencode($id)); // Aquí rediriges al formulario para mayores de edad
        exit();
    } elseif ($edad < 18) {
        header("Location: alta_menor.php?id=" . urlencode($id)); // Aquí rediriges al formulario para mayores de edad
        exit();
    }
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Socio</title>
</head>
<body>
    <h1>Agregar Nuevo Socio</h1>
    <form method="POST" action="">
        <!-- Campo para el ID del socio -->
        <label for="id">ID:</label>
        <input type="number" id="id" name="id" required><br>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br>

        <label for="apellidos">Apellido:</label>
        <input type="text" id="apellidos" name="apellidos" required><br>

        <label for="correo_email">correo_email:</label>
        <input type="correo_email" id="correo_email" name="correo_email" required><br>

        <label for="edad">Edad:</label>
        <input type="number" id="edad" name="edad" required><br>

        <input type="submit" value="Agregar Socio">
    </form>
    <br>
    <a href="lista_socios.php">Volver al listado</a>
</body>
</html>
