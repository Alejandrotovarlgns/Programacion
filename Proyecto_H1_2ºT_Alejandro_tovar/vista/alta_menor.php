<?php 
require_once '../controlador/SociosController.php';

// Supongamos que el ID se obtiene de la sesión o base de datos
session_start();
$id = $_SESSION['id_socio'] ?? $_GET['id'] ?? null; // Captura de sesión o URL

if (!$id) {
    die("Error: No se ha encontrado un ID de socio válido.");
}

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $controller = new SociosController();
    
    $id_plan = $_POST['id_plan'];
    $duracion_suscripcion = $_POST['duracion_suscripcion'];

    // Llamamos a la función para actualizar el usuario con el nuevo plan y duración
    $controller->agregarSocio2($id_plan, $duracion_suscripcion, $id);

    // Redirección según la edad del usuario
    header("Location: alta_menor2.php?id=" . urlencode($id)); // Redirigimos después de la eliminación
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
    
    <form method="POST" action="">
        <!-- ID enviado automáticamente como un campo oculto -->
        <input type="hidden" name="id" value="<?php echo htmlspecialchars($id); ?>">

        <label for="id_plan">Plan Base:</label>
        <select id="id_plan" name="id_plan" required>
            <option value="Básico">Básico</option>
        </select><br>

        <label for="duracion_suscripcion">Duración de la Suscripción:</label>
        <select id="duracion_suscripcion" name="duracion_suscripcion" required>
            <option value="Mensual">Mensual</option>
            <option value="Anual">Anual</option>
        </select><br>

        <input type="submit" value="Actualizar Socio">
    </form>
    
    <br>
    <a href="lista_socios.php">Volver al listado</a>
</body>
</html>
