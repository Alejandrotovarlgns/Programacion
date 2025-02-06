<?php
require_once '../modelo/class_socio.php';

class SociosController {
    private $socio;

    public function __construct() {
        $this->socio = new Socio();
    }

    public function agregarSocio($id, $nombre, $apellidos, $correo_email, $edad) {
        // Llama al método de la clase que maneja la actualización
        $this->socio->agregarSocio($id, $nombre, $apellidos, $correo_email, $edad);
    }

    public function agregarSocio2($id_plan, $duracion_suscripcion, $fecha_registro ) {
        // Llama al método de la clase que maneja la actualización
        $this->socio->agregarSocio2($id_plan, $duracion_suscripcion, $fecha_registro);
    }

    public function agregarusuario3($id_usuario, $nombre_paquete) {
        $this->socio->agregarusuario3($id_usuario, $nombre_paquete);
    }

    public function listarSocios() {
        return $this->socio->obtenerSocios();
    }

    public function obtenerSocioPorId($id_socio) {
        return $this->socio->obtenerSocioPorId($id_socio);
    }

    public function actualizarSocio($id_socio, $nombre, $apellido, $email, $telefono, $fecha_nacimiento) {
        $this->socio->actualizarSocio($id_socio, $nombre, $apellido, $email, $telefono, $fecha_nacimiento);
    }

        public function eliminarSocio($id_socio) {
            $this->socio->eliminarUsuario($id_socio);
        }
    } 
?>