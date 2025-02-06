<?php 
require_once '../controlador/SociosController.php';

// Iniciar sesión
session_start();

// Obtener el ID del socio desde sesión o URL
$id = $_SESSION['id_socio'] ?? $_GET['id'] ?? null;

if (!$id) {
    die("Error: No se ha encontrado un ID de socio válido.");
}

// Instanciar el controlador
$controller = new SociosController();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Obtener los datos del formulario
    $nombre_paquete = $_POST["nombre_paquete"];
    $id_usuario = $_POST["id_usuario"]; // Se obtiene el ID del input hidden

    // Llamar al método agregarusuario3 para agregar el paquete adicional
    $controller->agregarusuario3($nombre_paquete, $id_usuario);

    // Redirigir al usuario a la lista de usuarios
    header("Location: lista_socios.php");
    exit();
}
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Actualizar Plan de Socio</title>
</head>
<body>
    <h1>Actualizar Plan de Socio</h1>
    
    <form method="POST">
        <div class="mb-3">
            <label for="nombre_paquete" class="form-label">Nombre del Paquete</label>
            <select class="form-control" id="nombre_paquete" name="nombre_paquete" required>
                <option value="Infantil">Infantil </option>
            </select>
        </div>

        <!-- Enviar el ID del usuario en un campo oculto -->
        <input type="hidden" name="id_usuario" value="<?php echo htmlspecialchars($id); ?>">

        <!-- Botón para enviar el formulario -->
        <button type="submit" class="btn btn-primary w-100">Agregar Paquete</button>
    </form>
    
    <br>
    <a href="lista_socios.php">Volver al listado</a>
</body>
</html>
