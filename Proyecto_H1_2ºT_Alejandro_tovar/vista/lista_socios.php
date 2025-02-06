<?php
require_once '../controlador/SociosController.php';
$controller = new SociosController();
$socios = $controller->listarSocios(); // Utilizamos la función obtenerSocios para obtener los socios
?>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de socios</title>
    <!-- Añado el link de bootstrap en el encabezado -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>  
    <div class="container mt-4">
        <h1 class="mb-3">Socios Registrados</h1>
        
        <table class="table table-sm">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Email</th>
                    <th>Edad</th>
                    <th>Plan</th>
                    <th>Duración Suscripción</th>
                    <th>Nombre Paquete</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <?php foreach ($socios as $socio): ?>
                    <tr>
                        <td><?= $socio['id'] ?></td>
                        <td><?= $socio['nombre'] ?></td>
                        <td><?= $socio['apellidos'] ?></td>
                        <td><?= $socio['correo_email'] ?></td>
                        <td><?= $socio['edad'] ?></td>
                        <td><?= $socio['id_plan'] ?></td>
                        <td><?= $socio['duracion_suscripcion'] ?></td>
                        <td><?= $socio['nombre_paquete'] ?></td>
                        <td>
                            <a href="editar_socio.php?id=<?= $socio['id'] ?>" class="btn btn-link">Editar</a>
                            <a href="eliminar_socio.php?id=<?= $socio['id'] ?>" class="btn btn-link text-danger">Eliminar</a>
                        </td>
                    </tr>
                <?php endforeach; ?>
            </tbody>
        </table>
        
        <a href="alta_socio.php" class="btn btn-primary">Agregar un nuevo socio</a>
    </div>
    
    <!-- Añado el script de bootstrap al final del body -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
