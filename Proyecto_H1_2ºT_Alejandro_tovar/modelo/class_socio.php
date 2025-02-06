<?php
require_once '../config/class_conexion.php';

class Socio {
    private $conexion;

    public function __construct() {
        $this->conexion = new Conexion();
    }

    public function agregarSocio($id, $nombre, $apellidos, $correo_email, $edad) {
        $query = "INSERT INTO usuarios (id, nombre, apellidos, correo_email, edad) VALUES (?, ?, ?, ?, ?)";
        $sentencia = $this->conexion->conexion->prepare($query);
        $sentencia->bind_param("isssi",$id, $nombre, $apellidos, $correo_email, $edad);

        if ($sentencia->execute()) {
            echo "Socio agregado con éxito.";
        } else {
            echo "Error al agregar socio: " . $sentencia->error;
        }

        $sentencia->close();
    }

    public function agregarSocio2($id_plan, $duracion_suscripcion, $id ) {
        $query = "UPDATE usuarios set id_plan = ?,duracion_suscripcion =? where id =?";
        $sentencia = $this->conexion->conexion->prepare($query);
        $sentencia->bind_param("ssi",$id_plan, $duracion_suscripcion, $id );

        if ($sentencia->execute()) {
            echo "Socio agregado con éxito.";
        } else {
            echo "Error al agregar socio: " . $sentencia->error;
        }

        $sentencia->close();
    }

    public function agregarusuario3($nombre_paquete, $id_usuario) {
        $query = "INSERT INTO paquetes (nombre_paquete, id_usuario) VALUES (?, ?)";
        $sentencia = $this->conexion->conexion->prepare($query);
        $sentencia->bind_param("si", $nombre_paquete, $id_usuario); // "s" para string, "i" para integer
    
        if ($sentencia->execute()) {
            echo "Paquete agregado con éxito.";
        } else {
            echo "Error al agregar paquete: " . $sentencia->error;
        }
    
        $sentencia->close();
    }

    public function obtenerSocios() {
        $query = "SELECT 
    u.id, 
    u.nombre, 
    u.apellidos, 
    u.correo_email, 
    u.edad, 
    u.id_plan, 
    u.duracion_suscripcion, 
    p.nombre_paquete
FROM usuarios u
LEFT JOIN paquetes p ON u.id = p.id_usuario;";
        
        $resultado = $this->conexion->conexion->query($query);
        $usuarios = [];
        
        while ($fila = $resultado->fetch_assoc()) {
            $usuarios[] = $fila;
        }
        
        return $usuarios;
    }

    public function obtenerSocioPorId($id_socio) {
        $query = "SELECT * FROM socios WHERE id_socio = ?";
        $sentencia = $this->conexion->conexion->prepare($query);
        $sentencia->bind_param("i", $id_socio);
        $sentencia->execute();
        $resultado = $sentencia->get_result();
        return $resultado->fetch_assoc();
    }

   public function actualizarSocio($id_socio, $nombre, $apellido, $email, $edad) {
    // Actualiza la consulta para reflejar los campos de la tabla 'usuarios'
    $query = "UPDATE usuarios SET nombre = ?, apellidos = ?, correo_email = ?, edad = ? WHERE id = ?";
    $sentencia = $this->conexion->conexion->prepare($query);
    
    // Cambia el tipo de parámetros a "ssssi" para reflejar los tipos correctos
    $sentencia->bind_param("ssssi", $nombre, $apellido, $email, $edad, $id_socio);

    if ($sentencia->execute()) {
        echo "Usuario actualizado con éxito.";
    } else {
        echo "Error al actualizar usuario: " . $sentencia->error;
    }

    $sentencia->close();
}
    public function eliminarUsuario($id_usuario) {
        // Iniciamos la transacción para asegurar la integridad de la base de datos.
        $this->conexion->conexion->begin_transaction();
        
        try {
            // Ahora eliminamos el usuario de la tabla 'usuarios'
            $query = "DELETE FROM usuarios WHERE id = ?";
            $stmt = $this->conexion->conexion->prepare($query);
            $stmt->bind_param("i", $id_usuario);
            $stmt->execute();
            $stmt->close();
            
            // Si todo ha ido bien, confirmamos la transacción
            $this->conexion->conexion->commit();
            echo "Usuario eliminado con éxito.";
        } catch (Exception $e) {
            // Si algo falla, revertimos la transacción
            $this->conexion->conexion->rollback();
            echo "Error al eliminar usuario: " . $e->getMessage();
        }
    }
    
}
?>