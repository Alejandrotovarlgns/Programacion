<?php
require_once '../controlador/SociosController.php';

$controller = new SociosController();

if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $id_Socio = intval($_POST['id_Socio']);

    
    $controller->eliminarSocio($id_Socio); // Usamos la función de eliminarSocio
    header("Location: lista_Socios.php"); // Redirigimos después de la eliminación
    exit();
}

// Obtengo el ID del Socio desde la URL (si existe)
$id_Socio = isset($_GET['id']) ? $_GET['id'] : '';
?>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eliminar Socio</title>
</head>
<body>
    <h1>Eliminar Socio</h1>
    <form method="POST" action="">
        <label for="id_Socio">ID del Socio:</label>
        <!-- Escribo el ID obtenido desde la URL (ID del Socio en el que se ha clicado el botón de eliminar) -->
        <input type="number" name="id_Socio" value="<?= htmlspecialchars($id_Socio) ?>" required>
        <button type="submit">Eliminar</button>
    </form>
</body>
</html>
